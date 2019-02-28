/**
 * 
 */
package cn.ly.mlc.servlet;

import common.util.StringUtils;

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
public class MlcApiBase {

	protected org.apache.commons.logging.Log logger = org.apache.commons.logging.LogFactory.getLog(getClass());


	protected String executeRequest(HttpServletRequest request, String data) throws Exception {
		return "";
	}

	public void handleRequest(HttpServletRequest request, HttpServletResponse response, byte[] paramAesKey) throws ServletException, IOException {
	}

	public void handleWxAppRequest(HttpServletRequest request, HttpServletResponse response, byte[] paramAesKey) throws ServletException, IOException {
		logger.debug("==IP===[" + getRemoteIp(request) + "]");
		long time = System.currentTimeMillis();
		try {
			String data = request.getParameter("data");
			String ret = executeRequest(request, data);
			byte[] retBuf = ret.getBytes("utf-8");
			response.setContentType("application/Json");
			response.setContentLength(retBuf.length);
			response.getOutputStream().write(retBuf);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		time = System.currentTimeMillis() - time;
		logger.info("execute MlcApi use " + time + "ms");
	}

	/**
	 * 获得ip地址
	 */
	private String getRemoteIp(HttpServletRequest request) {
		String ip = "";
		try {
			ip = request.getHeader("x-forwarded-for");
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}
			String[] ips = ip.split(",");
			for (int i = 0; i < ips.length; i++) {
				if (!StringUtils.isNullOrEmpty(ips[i]) && !"unknown".equals(ips[i])) {
					ip = ips[i];
					break;
				}
			}
		} catch (Exception e) {
			ip = "error";
		}
		return ip;
	}

}
