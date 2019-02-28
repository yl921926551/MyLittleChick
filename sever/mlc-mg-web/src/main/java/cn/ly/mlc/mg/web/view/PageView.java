package cn.ly.mlc.mg.web.view;

/**
 * @author shidewen
 * 
 */
public class PageView {
	private int pageIndex;
	private int totalCount;
	private int totalPage;
	
	public void setPageInfo(int pageIndex, int rowsOfPage, int totalCount){
		this.pageIndex = pageIndex;
		this.totalCount = totalCount;
		if(rowsOfPage == 0){
			rowsOfPage = 10;
		}
		this.totalPage = (totalCount + rowsOfPage - 1) / rowsOfPage;
	}
	
	/**
	 * @return the pageIndex
	 */
	public int getPageIndex() {
		return pageIndex;
	}

	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * @return the totalPage
	 */
	public int getTotalPage() {
		return totalPage;
	}
}
