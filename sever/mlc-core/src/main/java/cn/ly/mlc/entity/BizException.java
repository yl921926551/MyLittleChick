package cn.ly.mlc.entity;

/**
 * @author niexin
 *
 */
public class BizException extends Exception {

	private String errorCode;
	
	/**
	 * 
	 */
	public BizException() {
	}

	/**
	 * @param arg0
	 */
	public BizException(String arg0) {
		super(arg0);
	}

	public BizException(String errorCode, String message){
		super(message);
		this.errorCode = errorCode;
	}
	
	/**
	 * @param arg0
	 */
	public BizException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public BizException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

}
