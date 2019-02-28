package cn.ly.mlc.mg.biz;

/**
 * 
 * @author ly
 *
 */
public class ApplicationBeanPostProcessor extends topdeep.common.mg.biz.ApplicationBeanPostProcessor {

	private boolean inited = false;

	@Override
	protected void initApplication() {
		super.initApplication();
		if (!inited) {
			inited = true;
			try {

			} catch (Throwable ex) {
				logger.error("initApplication error", ex);
			}
		}
	}

}
