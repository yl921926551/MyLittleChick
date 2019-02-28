/**
 * 
 */
package cn.ly.mlc.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 提供WXAPP的服务调用
 * 
 * @author lei.y
 *
 */
@Controller("mlcApiServlet")
public class MlcApi extends MlcApiBase implements HttpRequestHandler {

	public static ThreadLocal<String> threadLocal = new ThreadLocal<String>();



	@Override
	protected String executeRequest(HttpServletRequest request, String inputParam) throws Exception {
		return "";
	}

	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			handleWxAppRequest(request, response);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void handleWxAppRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			super.handleWxAppRequest(request, response, null);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	

}
