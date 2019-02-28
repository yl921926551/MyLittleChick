package cn.ly.mlc.web.entity.response;

import java.util.ArrayList;
import java.util.List;


public class FileUploadResponse extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<String> filePathList = new ArrayList<String>();

	/**
	 * @return the filePathList
	 */
	public List<String> getFilePathList() {
		return filePathList;
	}

	/**
	 * @param filePathList the filePathList to set
	 */
	public void setFilePathList(List<String> filePathList) {
		this.filePathList = filePathList;
	}

	
}
