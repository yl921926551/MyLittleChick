package cn.ly.mlc.util.img;

import java.io.File;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;


/**
 * 
 * @author shidewen
 *
 */
public class ThumbnailsUtils {

	public static void zoomOutImage(String srcImageFile, String newImageFile, int width,int height) throws Exception{
		Thumbnails.of(srcImageFile).size(width, height).toFile(newImageFile);  
	}
	
	public static void markImg(String targetImg, String outImg,String markImg, Positions positions, float alpha) throws Exception{
		//watermark(位置，水印图，透明度)  
		Thumbnails.of(targetImg).scale(1).watermark(positions,ImageIO.read(new File(markImg)),alpha).outputQuality(0.8f).toFile(outImg);  
	}
}
