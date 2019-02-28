package cn.ly.mlc.web.entity.request;

import topdeep.cms.entity.db.CmsResource;

public class FileUploadRequest extends BaseRequest {

	private String file;

	/**
	 * @return the file
	 */
	public String getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(String file) {
		this.file = file;
	}

	
	
}