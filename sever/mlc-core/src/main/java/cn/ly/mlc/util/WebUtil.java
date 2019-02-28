package cn.ly.mlc.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.util.StringUtils;

/**
 * 
 * @author shidewen
 *
 */
@SuppressWarnings("unchecked")
public final class WebUtil {

	/**
	 * 
	 * @Description: 获取用户访问ip
	 * @param @param request
	 * @param @return
	 * @throws
	 */
	public static String getRemoteIp(HttpServletRequest request) {
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


	/**
	 * 
	 * 
	 * @Description: 获取Session中得指定值
	 * @param @param key
	 * @param @return
	 * @throws
	 */
	public static <T> T getSessionAttribute(String key, HttpServletRequest request) {

		return (T) request.getSession().getAttribute(key);
	}

	/**
	 * 
	 * 
	 * @Description: 向session中设置值
	 * @param @param key
	 * @param @param value
	 * @throws
	 */
	public static void setSessionAttribute(String key, Object value, HttpServletRequest request) {
		request.getSession().setAttribute(key, value);
	}

	/**
	 * 
	 * 
	 * @Description: 获取客户端所有cookie
	 * @param @return
	 * @throws
	 */
	public static Cookie[] getAllCookies(HttpServletRequest request) {
		return request.getCookies();
	}

	/**
	 * 
	 * 
	 * @Description: 获取指定cookie值
	 * @param @param key
	 * @param @return
	 * @throws
	 */
	public static Cookie getCookieByKey(String key, HttpServletRequest request) {
		Cookie[] cookies = getAllCookies(request);
		Cookie result = null;
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				if (key.equals(cookie.getName())) {
					result = cookie;
					break;
				}
			}
		}

		return result;
	}

	/**
	 * 
	 * 
	 * @Description: 添加一条cookie信息
	 * @param @param key 键
	 * @param @param value 值
	 * @param @param path 路径
	 * @param @param maxAge 存活时间
	 * @throws
	 */
	public static void addCookie(String scheme, String key, String value, String path, Integer maxAge, HttpServletResponse response) {
		Cookie cookie = new Cookie(key, value);
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		if (scheme.equals("https")) {
			cookie.setSecure(true);
		}
		response.addCookie(cookie);
	}

}
