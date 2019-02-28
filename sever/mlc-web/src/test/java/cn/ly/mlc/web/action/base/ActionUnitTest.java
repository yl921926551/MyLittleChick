/**
 * 
 */
package cn.ly.mlc.web.action.base;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author niexin
 *
 */
public class ActionUnitTest extends ActionTest {

	/**
	 * 测试账号登录类型
	 */
	@Value("#{test['testLoginType']}")
	protected String testLoginType;
	/**
	 * 测试账号登录账号类型0身份证fa基金账号
	 */
	@Value("#{test['testLoginAccountType']}")
	protected String testLoginAccountType;
	/**
	 * 测试账号登录号码
	 */
	@Value("#{test['testLoginAccount']}")
	protected String testLoginAccount;

	/**
	 * 测试账号登录密码
	 */
	@Value("#{test['testLoginPassword']}")
	protected String testLoginPassword;

	@Value("#{test['purchaseFundCode']}")
	protected String purchaseFundCode;

	/**
	 * 微信url签名key
	 */
	@Value("#{test['testWxKey']}")
	protected String testWxKey;

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
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	protected void stopServer() throws Exception {
	}

	/**
	 * @return the testLoginType
	 */
	public String getTestLoginType() {
		return testLoginType;
	}

	/**
	 * @param testLoginType the testLoginType to set
	 */
	public void setTestLoginType(String testLoginType) {
		this.testLoginType = testLoginType;
	}

	/**
	 * @return the testLoginAccountType
	 */
	public String getTestLoginAccountType() {
		return testLoginAccountType;
	}

	/**
	 * @param testLoginAccountType the testLoginAccountType to set
	 */
	public void setTestLoginAccountType(String testLoginAccountType) {
		this.testLoginAccountType = testLoginAccountType;
	}

	/**
	 * @return the testLoginAccount
	 */
	public String getTestLoginAccount() {
		return testLoginAccount;
	}

	/**
	 * @param testLoginAccount the testLoginAccount to set
	 */
	public void setTestLoginAccount(String testLoginAccount) {
		this.testLoginAccount = testLoginAccount;
	}

	/**
	 * @return the testLoginPassword
	 */
	public String getTestLoginPassword() {
		return testLoginPassword;
	}

	/**
	 * @param testLoginPassword the testLoginPassword to set
	 */
	public void setTestLoginPassword(String testLoginPassword) {
		this.testLoginPassword = testLoginPassword;
	}

	/**
	 * @return the testWxKey
	 */
	public String getTestWxKey() {
		return testWxKey;
	}

	/**
	 * @param testWxKey the testWxKey to set
	 */
	public void setTestWxKey(String testWxKey) {
		this.testWxKey = testWxKey;
	}

}
