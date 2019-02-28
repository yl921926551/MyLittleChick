/**
 * 
 */
package cn.ly.mlc.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author niexin
 *
 */
public class TopdeepRequestUtils {

	private static ThreadLocal<HttpServletRequest> reqLocal = new ThreadLocal<HttpServletRequest>();

	/**
	 * 
	 */
	public TopdeepRequestUtils() {
		// TODO Auto-generated constructor stub
	}

	public static void setRequest(HttpServletRequest req) {
		reqLocal.set(req);
	}

	public static HttpServletRequest getRequest() {
		return reqLocal.get();
	}

}
