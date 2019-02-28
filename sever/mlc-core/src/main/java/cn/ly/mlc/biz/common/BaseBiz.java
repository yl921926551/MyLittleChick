package cn.ly.mlc.biz.common;

import java.util.List;


/**
 * 
 * @author shidewen
 *
 */
public interface BaseBiz extends IBaseBiz {
	
	public <T> T selectSingleObject(List<T> tlist);


}
