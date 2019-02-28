package cn.ly.mlc.entity;

import java.io.Serializable;

/**
 * 
 * @author shidewen
 *
 */
public class ImgView implements Serializable{
	private String type;
	
	private byte[] markImg;
	
	private byte[] thumbnailImg;

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the markImg
	 */
	public byte[] getMarkImg() {
		return markImg;
	}

	/**
	 * @param markImg the markImg to set
	 */
	public void setMarkImg(byte[] markImg) {
		this.markImg = markImg;
	}

	/**
	 * @return the thumbnailImg
	 */
	public byte[] getThumbnailImg() {
		return thumbnailImg;
	}

	/**
	 * @param thumbnailImg the thumbnailImg to set
	 */
	public void setThumbnailImg(byte[] thumbnailImg) {
		this.thumbnailImg = thumbnailImg;
	}
}
