/**
 * 
 */
package cn.ly.mlc.mg.action.base;

import java.lang.reflect.Method;

/**
 * @author niexin
 *
 */
public class ActionUnitTest extends ActionTest {

	protected void checkExecuteHasException(Object target, String methodName, Object[] params, String tipMsg) throws Exception {
		Class<?> type = target.getClass();
		Method[] methods = type.getMethods();
		Method callMethod = null;
		for (Method method : methods) {
			if (!method.getName().equals(methodName)) {
				continue;
			}
			if (method.getParameterTypes().length != params.length) {
				continue;
			}
			Class<?>[] paramTypes = method.getParameterTypes();
			boolean find = false;
			for (int i = 0; i < paramTypes.length; i++) {
				if (params[i] == null) {
					continue;
				}
				Class<?> paramType = params[i].getClass();
				if (!paramTypes[i].isAssignableFrom(paramType)) {
					find = true;
					break;
				}
			}
			if (!find) {
				callMethod = method;
				break;
			}
		}
		if (callMethod == null) {
			throw new Exception("不能找到要调用的方法:" + methodName);
		}
		try {
			callMethod.invoke(target, params);
			assert (false) : tipMsg;
		} catch (Exception ex) {
		}
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	protected void startServer() throws Exception {
		// WeChatSession session = (WeChatSession) applicationContext.getBean("wechatSession");
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	protected void stopServer() throws Exception {
	}

}
