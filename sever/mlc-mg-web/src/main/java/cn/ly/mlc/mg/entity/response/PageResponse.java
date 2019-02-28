package cn.ly.mlc.mg.entity.response;

import cn.ly.mlc.mg.web.view.PageView;

/**
 * @author niexin
 *
 */
public class PageResponse extends BaseResponse {
	private PageView pageData = new PageView();

	/**
	 * @return the pageData
	 */
	public PageView getPageData() {
		return pageData;
	}

}
