package cn.ly.mlc.web.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import topdeep.zhst.biz.ZeroMqBiz;
import topdeep.zhst.biz.common.ZhstCommonSystemBiz;
import topdeep.zhst.biz.common.ZhstSystemBiz;
import topdeep.zhst.biz.common.impl.ZhstSystemParamBiz;

/**
 * 
 * @author shidewen
 *
 */
@Service
public class ApplicationBeanPostProcessor extends topdeep.common.biz.ApplicationBeanPostProcessor {

	private boolean inited = false;

	@Autowired
	@Qualifier("zhstSystemBiz")
	private ZhstSystemBiz zhstSystemBiz;
	
	@Autowired
	@Qualifier("zhstCommonSystemBiz")
	private ZhstCommonSystemBiz zhstCommonSystemBiz;
	
	@Autowired
	@Qualifier("zhstSystemParamBiz")
	protected ZhstSystemParamBiz zhstSystemParamBiz;
	
	@Autowired
	@Qualifier("zeroMqBiz")
	private ZeroMqBiz mqBiz;

	@Override
	protected void initApplication() {
		super.initApplication();
		if (!inited) {
			inited = true;
			try {
				// 加载字典
				zhstCommonSystemBiz.initDict();
				// 加载省市
				zhstSystemBiz.loadProvinceAndCity();
				// 加载参数
				zhstSystemParamBiz.init();
				
			} catch (Throwable ex) {
				logger.error("initApplication error", ex);
			}
			try {
				mqBiz.init();
				logger.debug("init zeroMqBiz@"+this);
			} catch (Throwable ex) {
				logger.error("init zeroMqBiz error", ex);
			}
		}
	}
	
}
