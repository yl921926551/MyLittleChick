package cn.ly.mlc.entity.base;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAnySetter;


/**
 * 
 * @author shidewen
 *
 */
public class BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2763436364292618569L;

	@JsonAnySetter
	public void handleUnknown(String key, Object value) {
		// do something: put to a Map; log a warning, whatever
	}
	
	public Integer getRowVersion() {
		return -2;
	}

}
