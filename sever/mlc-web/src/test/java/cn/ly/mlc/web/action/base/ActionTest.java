/**
 * 
 */
package cn.ly.mlc.web.action.base;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.URL;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.xml.XmlConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.util.StringUtils;

/**
 * @author niexin
 *
 */
@ContextConfiguration(locations = {
	"classpath:spring-test-config.xml"
})
public class ActionTest extends AbstractTestNGSpringContextTests {

	@Value("#{test['chromeDriverPath']}")
	private String chromeDriverPath;

	@Value("#{test['screenSavePath']}")
	protected String screenSavePath;

	/**
	 * local_chrome | remote_chrome | local_firefox | remote_firefox
	 */
	@Value("#{test['webDriverType']?:'remote_chrome'}")
	private String webDriverType;

	private Server httpServer;

	@Value("#{test['webappPath']}")
	protected String webappPath = "";
	@Value("#{test['verifyKeys']}")
	private String verifyKeys;
	private String testId = StringUtils.dateTimeToString(new Date(), "HHmmss");
	private int fileNo = 0;

	/**
	 * 测试账号的来源
	 */
	@Value("#{test['testP1']}")
	protected String testP1;
	/**
	 * 测试账号的OpenId
	 */
	@Value("#{test['testP3']}")
	protected String testP3;

	@Value("#{test['testWxKey']}")
	protected String testWxKey;

	private String serverPrefix = "192.168";

	protected String localServer;

	protected boolean localDebug = false;

	@Value("#{test['localTest']?:false}")
	protected boolean localTest;

	private Log log = LogFactory.getLog(getClass());

	private String getServerIp() throws Exception {
		Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
		while (e.hasMoreElements()) {
			NetworkInterface networkInterface = e.nextElement();
			// logger.debug(networkInterface.getName()+"-start");
			if (!networkInterface.isUp() || networkInterface.isLoopback() || networkInterface.isVirtual()) {
				continue;
			}
			Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
			while (addresses.hasMoreElements()) {
				InetAddress address = addresses.nextElement();
				String localIp = address.getHostAddress();
				// logger.debug(address.getHostAddress());
				if (localIp.startsWith(serverPrefix)) {
					logger.debug("find localIp = [" + localIp + "]");
					return localIp;
				}
			}
			// logger.debug(networkInterface.getName()+"-end");
		}
		throw new Exception("can't find local ip");
	}

	protected static final int TEST_SERVER_PORT = 8090;

	protected static final String TEST_SERVER_CONTEXT_PATH = "/wechat-mg-web";

	protected MockHttpSession session;
	protected MockHttpServletRequest request;

	protected void startSession() {
		session = new MockHttpSession();
	}

	protected void endSession() {
		session.clearAttributes();
		session = null;
	}

	protected void startRequest() {
		request = new MockHttpServletRequest();
		request.setSession(session);
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	}

	protected void endRequest() {
		((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).requestCompleted();
		RequestContextHolder.resetRequestAttributes();
		request = null;
	}

	protected WebDriver getLocalFirefoxDriver() {
		// Create a new instance of the Firefox driver
		// Notice that the remainder of the code relies on the interface,
		// not the implementation.
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	protected WebDriver getLocalChromeDriver() {
		// We could use any driver for our tests...
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// ... but only if it supports javascript
		capabilities.setJavascriptEnabled(true);
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);

		return new ChromeDriver(capabilities);
	}

	protected WebDriver getRemoteChromeDriver() throws MalformedURLException {
		// We could use any driver for our tests...
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// ... but only if it supports javascript
		capabilities.setJavascriptEnabled(true);
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		// Get a handle to the driver. This will throw an exception
		// if a matching driver cannot be located
		return new RemoteWebDriver(new URL("http://192.168.0.96:4444/wd/hub"), capabilities);
		// Query the driver to find out more information
		// Capabilities actualCapabilities = ((RemoteWebDriver) driver).getCapabilities();
	}

	protected WebDriver getWebDriver() throws MalformedURLException {
		if ("local_chrome".equals(webDriverType)) {
			return getLocalChromeDriver();
		} else if ("local_firefox".equals(webDriverType)) {
			return getLocalFirefoxDriver();
		} else if ("remote_firefox".equals(webDriverType)) {
			return null;
		} else {
			// remote_chrome
			return getRemoteChromeDriver();
		}
	}

	protected void startServer() throws Exception {
		localServer = "http://" + getServerIp() + ":" + TEST_SERVER_PORT + TEST_SERVER_CONTEXT_PATH;
		httpServer = new Server(TEST_SERVER_PORT);
		XmlConfiguration xmlConfig = new XmlConfiguration(new File("src/test/resources/jetty.xml").toURI().toURL());
		xmlConfig.configure(httpServer);
		File currPath = new File(".");
		WebAppContext context = new WebAppContext();
		context.setDescriptor(webappPath + "/WEB-INF/web.xml");
		context.setResourceBase(webappPath);
		context.setContextPath(TEST_SERVER_CONTEXT_PATH);
		context.setParentLoaderPriority(true);
		httpServer.setHandler(context);
		httpServer.start();
		if (localDebug) {
			httpServer.join();
		}
	}

	protected void stopServer() throws Exception {
		if (httpServer != null) {
			httpServer.stop();
		}
	}

	@BeforeTest
	public void beforeTest() {
		startSession();
		startRequest();
	}

	@AfterTest
	public void afterTest() throws Exception {
		stopServer();
		endSession();
		endRequest();
	}

	@Test(enabled = false)
	public void executebase() {
		assert (true);
	}

	private String getSavePath() {
		StackTraceElement[] stackTracks = Thread.currentThread().getStackTrace();
		int methodIndex = 0;
		for (int i = 0; i < stackTracks.length; i++) {
			if (stackTracks[i].getMethodName().startsWith("invoke")) {
				methodIndex = i - 1;
				break;
			}
		}
		if (methodIndex < 0) {
			methodIndex = 0;
		}

		String testMethodName = stackTracks[methodIndex].getMethodName();

		fileNo++;
		Class<?> type = getClass();
		String testName = type.getName();
		int lastPos = testName.lastIndexOf(".");
		lastPos = testName.lastIndexOf(".", lastPos - 1);
		testName = testName.substring(lastPos + 1).replaceAll("\\.", "_");
		return screenSavePath + "/" + StringUtils.dateTimeToString(new Date(), "yyyyMMdd") + "/" + testName + "/" + testId + "/" + testMethodName + "_"
				+ fileNo + ".png";
	}

	public void screenSave(WebDriver driver) {
		String filepath = getSavePath();
		String dir = filepath.substring(0, filepath.lastIndexOf("/"));
		File fdir = new File(dir);
		if (!fdir.exists()) {
			fdir.mkdirs();
		}
		File source_file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); // 关键代码，执行屏幕截图，默认会把截图保存到temp目录
		source_file.renameTo(new File(filepath));
	}

	protected String urlQueryStr(TreeMap<String, String> paramMap) {
		String urlQuertStr = "?test=test";
		if (paramMap == null) {
			paramMap = new TreeMap<String, String>();
			paramMap.put("p1", "1");
			paramMap.put("p3", "post123");
			paramMap.put("p4", "12123123.123123");
		}
		String verifyKey = "";
		StringBuffer sb = new StringBuffer();
		String regex = "^p\\d{1,2}$";
		Pattern p = Pattern.compile(regex);
		for (Iterator<Entry<String, String>> it = paramMap.entrySet().iterator(); it.hasNext();) {
			Entry<String, String> entry = it.next();
			if (entry.getKey().equals("p99")) {
				continue;
			}
			if (StringUtils.isNullOrEmpty(entry.getValue())) {
				continue;
			}
			Matcher m = p.matcher(entry.getKey());
			if (!m.find()) {
				continue;
			}
			if (entry.getKey().equals("p4")) {
				String p4 = new Date().getTime() + "." + new Date().getTime();
				urlQuertStr += "&" + entry.getKey() + "=" + p4;
				sb.append(entry.getKey()).append(p4);
			} else {
				urlQuertStr += "&" + entry.getKey() + "=" + entry.getValue() + "";
				sb.append(entry.getKey()).append(entry.getValue());
			}
			if (entry.getKey().equals("p1")) {
				verifyKey = getVerifyKey(entry.getValue());
			}
		}
		String signmsg = sb.toString();
		log.debug("verifyParam,signmsg=[" + signmsg + ";verifyKey=" + verifyKey + "]");
		try {
			signmsg = new common.util.MD5(sb.toString() + verifyKey, "utf-8").getMd5String();
		} catch (UnsupportedEncodingException e) {
			log.error("无法使用utf-8编码进行MD5计算: " + sb.toString());
			signmsg = new common.util.MD5(sb.toString() + verifyKey).getMd5String();
		}
		urlQuertStr += "&p99=" + signmsg + "&verifyKey=" + verifyKey;
		return urlQuertStr;
	}

	/**
	 * @return the serverPrefix
	 */
	public String getServerPrefix() {
		return serverPrefix;
	}

	/**
	 * @param serverPrefix the serverPrefix to set
	 */
	public void setServerPrefix(String serverPrefix) {
		this.serverPrefix = serverPrefix;
	}

	/**
	 * @return the webappPath
	 */
	public String getWebappPath() {
		return webappPath;
	}

	/**
	 * @param webappPath the webappPath to set
	 */
	public void setWebappPath(String webappPath) {
		this.webappPath = webappPath;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.test.context.testng.AbstractTestNGSpringContextTests#springTestContextPrepareTestInstance()
	 */
	@Override
	@BeforeClass(alwaysRun = true, dependsOnMethods = "springTestContextBeforeTestClass")
	protected void springTestContextPrepareTestInstance() throws Exception {
		// TODO Auto-generated method stub
		super.springTestContextPrepareTestInstance();
		startServer();
	}

	private String getVerifyKey(String src) {
		log.debug("verifyKeys=" + verifyKeys);
		if (!StringUtils.isNullOrEmpty(verifyKeys) && !StringUtils.isNullOrEmpty(src)) {
			String[] keyValues = verifyKeys.split(",");
			for (int i = 0; i < keyValues.length; i = i + 2) {
				if (src.equals(keyValues[i])) {
					return keyValues[i + 1];
				}
			}
		}
		return "";
	}

	protected WebElement getWebElementById(WebDriver driver, String elementId) {
		WebElement element = driver.findElement(By.id(elementId));
		if (element == null) {
			logger.warn("can't find element: " + elementId);
		}
		return element;
	}

	protected void setInputElementValue(WebDriver driver, String inputId, String value) {
		WebElement input = getWebElementById(driver, inputId);
		if (input != null) {
			input.sendKeys(value);
		}
		// 输入信息后截图
		screenSave(driver);
	}

	protected void clickElement(WebDriver driver, String elementId) {
		WebElement element = getWebElementById(driver, elementId);
		if (element != null) {
			element.click();
		}
		// 输入信息后截图
		screenSave(driver);
	}

	protected String getElementContent(WebDriver driver, String elementId) {
		WebElement element = getWebElementById(driver, elementId);
		if (element != null) {
			return element.getText().trim();
		}
		return "";
	}

	protected WebElement waitElementByIdDisplay(WebDriver driver, final String elementId) {
		WebElement element = (new WebDriverWait(driver, 10)).until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver d) {
				WebElement e = getWebElementById(d, elementId);
				if (e.isDisplayed()) {
					screenSave(d);
					return e;
				} else {
					return null;
				}
			}
		});
		return element;
	}

	protected WebElement waitElementByIdDisplay(WebDriver driver, final String elementId, final String maskId) {
		return waitElementByIdDisplay(driver, 30, elementId, maskId);
	}

	protected WebElement waitElementByIdDisplay(WebDriver driver, int timeout, final String elementId, final String maskId) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.invisibilityOfElementLocated(By.id(maskId)));
		WebElement element = (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver d) {
				WebElement e = getWebElementById(d, elementId);
				if (e.isDisplayed()) {
					screenSave(d);
					return e;
				} else {
					return null;
				}
			}
		});
		return element;
	}

	protected void waitAlertAndConfirm(WebDriver driver, String tipTitle, String tipContent) {
		// 等待对话框显示
		waitElementByIdDisplay(driver, "alertdialog_div");
		// 对话框显示后截图
		screenSave(driver);
		// 这里应当加上对话框标题和提示内容的判断,下同
		checkElementContent(driver, "global_alert_title", tipTitle);
		checkElementContent(driver, "global_alert_content", tipContent);
		// 确认对话框
		clickElement(driver, "alertConfirm_btn");
		// 确认后截图
		screenSave(driver);
	}

	protected void checkElementContent(WebDriver driver, String elementId, String content) {
		String s = getElementContent(driver, elementId);
		assert (s.indexOf(content) >= 0) : "提示内容[" + s + "]不对，应当是:" + content;
	}

	public String getVerifyKeys() {
		return verifyKeys;
	}

	public void setVerifyKeys(String verifyKeys) {
		this.verifyKeys = verifyKeys;
	}

	/**
	 * @return the screenSavePath
	 */
	public String getScreenSavePath() {
		return screenSavePath;
	}

	/**
	 * @param screenSavePath the screenSavePath to set
	 */
	public void setScreenSavePath(String screenSavePath) {
		this.screenSavePath = screenSavePath;
	}

	/**
	 * @return the testP1
	 */
	public String getTestP1() {
		return testP1;
	}

	/**
	 * @param testP1 the testP1 to set
	 */
	public void setTestP1(String testP1) {
		this.testP1 = testP1;
	}

	/**
	 * @return the testP3
	 */
	public String getTestP3() {
		return testP3;
	}

	/**
	 * @param testP3 the testP3 to set
	 */
	public void setTestP3(String testP3) {
		this.testP3 = testP3;
	}

}
