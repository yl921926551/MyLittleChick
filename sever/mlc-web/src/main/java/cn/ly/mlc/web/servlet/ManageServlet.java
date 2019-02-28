package cn.ly.mlc.web.servlet;

import common.util.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import topdeep.common.entity.manage.def.MSBaseInOut;
import topdeep.common.entity.manage.def.MSBaseInOutFactory;
import topdeep.common.entity.manage.def.MSBaseInput;
import topdeep.common.entity.manage.def.MSBaseOutput;
import topdeep.common.util.sign.DocumentUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 
 * @author ly
 *
 */
@Controller("manageServlet")
public class ManageServlet implements HttpRequestHandler {

	private Log logger = LogFactory.getLog(getClass());

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.HttpRequestHandler#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if ("GET".equals(request.getMethod().toUpperCase())) {
				handleGetRequest(request, response);
			} else {
				handlePostRequest(request, response);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
	}

	public void handleGetRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	public void checkDirExists(String filePath) {
		int k = filePath.lastIndexOf("/");
		filePath = filePath.substring(0, k);
		File f = new File(filePath);
		f.mkdirs();
	}

	public void handlePostRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

	}

	private String rtnNullOrEmpty(String src, String defaultStr) {
		if (StringUtils.isNullOrEmpty(src)) {
			return defaultStr;
		}
		return src;
	}

	private Long processLongData(Long l) {
		if (l == null) {
			return System.currentTimeMillis();
		}
		return l;
	}

	private Integer processIntegerData(Integer l) {
		if (l == null) {
			return 0;
		}
		return l;
	}

	private Date processDateStr(String dateStr) {
		Date date = null;
		try {
			if (!StringUtils.isNullOrEmpty(dateStr)) {
				if (dateStr.length() == 8) {
					date = StringUtils.stringToDate(dateStr, "yyyyMMdd");
				} else if (dateStr.length() == 14) {
					date = StringUtils.stringToDate(dateStr, "yyyyMMddhhmmss");
				} else {
					date = new Date();
				}
			} else {
				date = new Date();
			}
		} catch (Exception e) {
			date = new Date();
		}
		return date;
	}

}