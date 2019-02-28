package cn.ly.mlc.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import topdeep.common.util.qrcode.QRCodeEventsUtils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;

public class QrCodeGenerateUtil {

	private static final Log logger = LogFactory.getLog(QrCodeGenerateUtil.class);
	
	public static String generateQrCode(String data) {
		String qrcode = "";
		try {
			int width = 300;
			int height = 300;
			BarcodeFormat format = BarcodeFormat.QR_CODE;
			Hashtable<EncodeHintType, String> table = new Hashtable<EncodeHintType, String>();
			table.put(EncodeHintType.CHARACTER_SET, "utf-8");
			BufferedImage img = QRCodeEventsUtils.createdQRCode(data, width, height, table, format);
			// GenerateImage(img);
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			ImageIO.write(img, "JPEG", stream);
			qrcode = Base64.encodeBase64String(stream.toByteArray());
		} catch (Exception e) {
			logger.error("generateQrCode error", e);
		}
		return qrcode;
	}

	// @Test
	// public static void testGenerate() {
	// System.out.println(generateQrCode("www.baidu.com"));
	// }
	//
	// public static void GenerateImage(BufferedImage img) throws IOException {
	// File outputfile = new File("/Users/develop/Desktop/baidu.png");
	// ImageIO.write(img, "png", outputfile);
	// }

}
