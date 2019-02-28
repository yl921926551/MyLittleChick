package cn.ly.mlc.mg.entity.request;

public class PageRequest extends BaseRequest {

	/** 页码 **/
	private int pageIndex;
	
	/** 跳转页面 **/
	private int jumpPageIndex;
    
	/** 一页几行 **/
	private int rowsOfPage = 10;
    
    /** 页数 **/
    private int pageCount;
    
    /** 总数 **/
    private int totalCount;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getJumpPageIndex() {
		return jumpPageIndex;
	}

	public void setJumpPageIndex(int jumpPageIndex) {
		this.jumpPageIndex = jumpPageIndex;
	}

	public int getRowsOfPage() {
		return rowsOfPage;
	}

	public void setRowsOfPage(int rowsOfPage) {
		this.rowsOfPage = rowsOfPage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
}
