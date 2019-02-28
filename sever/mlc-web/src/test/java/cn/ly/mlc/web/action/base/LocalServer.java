/**
 * 
 */
package cn.ly.mlc.web.action.base;

import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.xml.XmlConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.util.StringUtils;

/**
 * @author niexin
 *
 */
@ContextConfiguration(locations = {
	"classpath:local-server-config.xml"
})
public class LocalServer extends AbstractTestNGSpringContextTests {

	private Server httpServer;

	@Value("#{test['webappPath']}")
	private String webappPath = "";

	protected String localServer;

	private String serverPrefix = "";

	@Value("#{test['localServerPort']?:8090}")
	protected int localServerPort = 8090;

	@Value("#{test['localServerContextPath']?:'/web'}")
	protected String localServerContextPath = "/web";

	protected boolean localDebug = false;

	public LocalServer() {
		localDebug = true;
	}

	@Override
	@BeforeClass(alwaysRun = true, dependsOnMethods = "springTestContextBeforeTestClass")
	protected void springTestContextPrepareTestInstance() throws Exception {
		// TODO Auto-generated method stub
		super.springTestContextPrepareTestInstance();
		startServer();
	}

	@Test()
	public void execute() {

	}

	private String getServerIp() throws Exception {
		if (StringUtils.isNullOrEmpty(serverPrefix)) {
			return "127.0.0.1";
		}
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

	protected void startServer() throws Exception {
		localServer = "http://" + getServerIp() + ":" + localServerPort + localServerContextPath;
		httpServer = new Server(localServerPort);
		// File currPath = new File(".");
		// System.setProperty("jetty.home",currPath.getAbsolutePath()+"/src/test/resources");
		// logger.debug("["+currPath.getAbsolutePath()+"]");
		WebAppContext context = new WebAppContext();
		context.setDescriptor(webappPath + "/WEB-INF/web.xml");
		context.setResourceBase(webappPath);
		context.setContextPath(localServerContextPath);
		context.setParentLoaderPriority(true);
		httpServer.setHandler(context);
		XmlConfiguration configuration = null;
		configuration = new XmlConfiguration(new FileInputStream("src/test/resources/jetty.xml"));
		configuration.configure(httpServer);
		httpServer.start();
		httpServer.join();

		// server.setHandler(new DefaultHandler());
		// try {
		// XmlConfiguration configuration = null;
		// configuration = new XmlConfiguration(new FileInputStream("src/test/resources/jetty.xml"));
		// configuration.configure(httpServer);
		// httpServer.start();
		// httpServer.join();
		// } catch (Exception e1) {
		// logger.error("jetty服务启动失败", e1);
		// }

	}

	protected void stopServer() throws Exception {
		if (httpServer != null) {
			httpServer.stop();
		}
	}
}
