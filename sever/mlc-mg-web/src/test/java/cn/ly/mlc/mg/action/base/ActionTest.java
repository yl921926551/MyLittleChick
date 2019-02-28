/**
 * 
 */
package cn.ly.mlc.mg.action.base;

import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.xml.XmlConfiguration;
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

/**
 * @author niexin
 *
 */
@ContextConfiguration(locations = {
	"classpath:spring-test-config.xml"
})
public class ActionTest extends AbstractTestNGSpringContextTests {

	protected Log logger = LogFactory.getLog(getClass());

	private Server httpServer;

	@Value("#{test['webappPath']}")
	protected String webappPath = "";

	private String serverPrefix = "192.168";

	protected String localServer;

	protected boolean localDebug = false;

	@Value("#{test['localTest']?:false}")
	protected boolean localTest;

	private String getServerIp() throws Exception {
		Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
		while (e.hasMoreElements()) {
			NetworkInterface networkInterface = e.nextElement();
			// log.debug(networkInterface.getName()+"-start");
			if (!networkInterface.isUp() || networkInterface.isLoopback() || networkInterface.isVirtual()) {
				continue;
			}
			Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
			while (addresses.hasMoreElements()) {
				InetAddress address = addresses.nextElement();
				String localIp = address.getHostAddress();
				// log.debug(address.getHostAddress());
				if (localIp.startsWith(serverPrefix)) {
					logger.debug("find localIp = [" + localIp + "]");
					return localIp;
				}
			}
			// log.debug(networkInterface.getName()+"-end");
		}
		throw new Exception("can't find local ip");
	}

	protected static final int TEST_SERVER_PORT = 8090;

	protected static final String TEST_SERVER_CONTEXT_PATH = "/zhst";

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

}
