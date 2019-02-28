package cn.ly.mlc.entity.base;

import common.entity.Page;

/**
 * 
 * @author shidewen
 *
 */
public class PageImpl implements Page{

	private int rowsOfPage;
	private int pageIndex ;
	private int totalRowsCount;
   public  PageImpl(int pageIndex,int rowsOfPage){
		this.pageIndex=pageIndex;
		this.rowsOfPage=rowsOfPage;
	}
   public  PageImpl(){
		this.pageIndex=0;
		this.rowsOfPage=10;
	}
	
	public int getBegin() {
		return pageIndex * rowsOfPage;
	}

	public int getEnd() {
		return getBegin() + rowsOfPage;
	}
    
	/**
	 * @return the rowsOfPage
	 */
	public int getRowsOfPage() {
		return rowsOfPage;
	}

	/**
	 * @param rowsOfPage the rowsOfPage to set
	 */
	public void setRowsOfPage(int rowsOfPage) {
		this.rowsOfPage = rowsOfPage;
	}

	/**
	 * @return the pageIndex
	 */
	public int getPageIndex() {
		return pageIndex;
	}

	/**
	 * @param pageIndex the pageIndex to set
	 */
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getTotalRowsCount() {
		return totalRowsCount;
	}

	public void setTotalRowsCount(int totalRowsCount) {
		this.totalRowsCount = totalRowsCount;
	}
  
   
}
