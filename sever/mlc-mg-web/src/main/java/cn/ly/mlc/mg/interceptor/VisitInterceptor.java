package cn.ly.mlc.mg.interceptor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import common.util.HttpUtils;
import common.util.StringUtils;
import common.web.annotation.TopdeepMethodAttribute;
import cn.ly.mlc.mg.biz.WebUserRuntimeBiz;

/**
 * 
 * @author shidewen
 *
 */
public class VisitInterceptor extends HandlerInterceptorAdapter {

	private static Log logger = LogFactory.getLog(VisitInterceptor.class);

	private Log timeLogger = LogFactory.getLog("topdeep.zhst.timer");

	private Map<Method, TopdeepMethodAttribute> methodMap = new HashMap<Method, TopdeepMethodAttribute>();

	@Autowired
	private WebUserRuntimeBiz webUserRuntimeBiz;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle (javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		long startTime = System.currentTimeMillis();
		HandlerMethod method = (HandlerMethod) handler;
		String methodName = method.getBeanType().getSimpleName() + "." + method.getMethod().getName();
		request.setAttribute("startTime", startTime);
		request.setAttribute("executeMethod", methodName);
		
		String reqUri = request.getRequestURI(); // 请求uri
		String visitUrl = request.getQueryString();
		if (!StringUtils.isNullOrEmpty(visitUrl)) {
			visitUrl = reqUri + "?" + visitUrl;
		} else {
			visitUrl = reqUri;
		}
		webUserRuntimeBiz.setCurrentVisitUrl(visitUrl);
		String context = request.getContextPath() + "/"; // 请求上下文
		
		boolean loginRequired = getMethodAttr(method).loginRequired();
		boolean isAjaxMethod = getMethodAttr(method).isAjaxMethod();
		
		if (loginRequired) {
			if (!webUserRuntimeBiz.isLogin()) {
				if (isAjaxMethod) {
					response.getWriter().write("needLogin");
				} else {
					if (reqUri.endsWith("signIn.action")) {
						response.sendRedirect(context + "h/signIn.action");
					} else {
						response.sendRedirect(context + "home/login.action?returnUrl=" + HttpUtils.urlEncode(visitUrl));
					}
				}
				return false;
			}
		}
		logger.debug("execute [" + methodName + "]");
		return super.preHandle(request, response, handler);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#postHandle (javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		if (modelAndView != null) {
			request.setAttribute("result_view", modelAndView.getViewName());
		}
		super.postHandle(request, response, handler, modelAndView);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter# afterCompletion(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		long startTime = (Long) request.getAttribute("startTime");
		String methodName = (String) request.getAttribute("executeMethod");
		boolean isHeart = "Heart.execute".equals(methodName);
		if (isHeart) {
			super.afterCompletion(request, response, handler, ex);
			return;
		}
		long endTime = System.currentTimeMillis();
		long executeTime = endTime - startTime;
		long totalTime = System.currentTimeMillis();
		long logExecuteTime = totalTime - endTime;
		long totalExecuteTime = totalTime - startTime;
		timeLogger.debug("execute [" + methodName + "]=" + executeTime + "ms,logger=" + logExecuteTime + ",total=" + totalExecuteTime);
		super.afterCompletion(request, response, handler, ex);
	}

	private TopdeepMethodAttribute getMethodAttr(HandlerMethod method) throws Exception {
		TopdeepMethodAttribute methodAttribute = null;
		if (!methodMap.containsKey(method.getMethod())) {
			synchronized (this) {
				if (!methodMap.containsKey(method.getMethod())) {
					methodAttribute = method.getMethod().getAnnotation(TopdeepMethodAttribute.class);
					if (methodAttribute == null) {
						throw new Exception("method " + method.getBeanType().getSimpleName() + "." + method.getMethod().getName()
								+ " need Annotation @TopdeepMethodAttribute");
					}
					methodMap.put(method.getMethod(), methodAttribute);
				}
			}
		}
		methodAttribute = methodMap.get(method.getMethod());
		return methodAttribute;
	}

}
