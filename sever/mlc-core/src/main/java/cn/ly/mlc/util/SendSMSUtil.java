package cn.ly.mlc.util;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

import flexjson.JSONDeserializer;

/**
 * 短信码生成
 */
public class SendSMSUtil {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static Logger log = Logger.getLogger(SendSMSUtil.class);

	public static String sendValidateMess(String mobile,String url,String appSecret,String appKey,String nonce,String templateid,String codelen) throws IOException {
        String curTime = String.valueOf((new Date().getTime() / 1000L));
        String checkSum = getCheckSum(appSecret, nonce, curTime);

        Map<String, String> headMap = new HashMap<String, String>();
        headMap.put("AppKey", appKey);
        headMap.put("Nonce", nonce);
        headMap.put("CurTime", curTime);
        headMap.put("CheckSum", checkSum);
        headMap.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		List<BasicNameValuePair> formparams = new ArrayList<BasicNameValuePair>();
		formparams.add(new BasicNameValuePair("mobile", mobile));
		formparams.add(new BasicNameValuePair("templateid", templateid));
		formparams.add(new BasicNameValuePair("codeLen", codelen));
		HttpResult result = HttpUtil.post(url, headMap, formparams);
		String json = result.getBody();
		if (result.getStatusCode() == 200) {
			ReturnMsgView msgView = new JSONDeserializer<ReturnMsgView>().use(null, ReturnMsgView.class).deserialize(json);
			String obj = msgView.getObj();
			if (obj != null && !"".equals(obj)) {
				log.info("key = " + "regist-" + mobile + ";value=" + obj);
				return obj;
			}
		}
        return "";
    }

	private static String getCheckSum(String appSecret, String nonce,
                                     String curTime) {
        return encode("sha1", appSecret + nonce + curTime);
    }

    private static String encode(String algorithm, String value) {
        if (value == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(value.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }

}
