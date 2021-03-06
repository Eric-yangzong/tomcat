package ex02.pyrmont;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import ex01.pyrmont.HttpServer;

public class ServletProcessor2 {
	public void process(Request request, Response response) {
		String uri = request.getUri();
		String servletName = uri.substring(uri.lastIndexOf("/") + 1);
		URLClassLoader loader = null;
		try {
			// create a URLClassLoader
			URL[] urls = new URL[1];
			URLStreamHandler streamHandler = null;
			File classPath = new File(HttpServer.WEB_ROOT);
			// the forming of repository is taken from the
			// createClassLoader method in
			// org.apache.catalina.startup.ClassLoaderFactory
			String repository = (new URL("file", null, classPath.getCanonicalPath() + File.separator)).toString();
			// the code for forming the URI is taken from
			// the addRepository method in
			// org.apache.catalina.loader.StandardClassLoader.
			urls[0] = new URL(null, repository, streamHandler);
			loader = new URLClassLoader(urls);

		} catch (IOException e) {
			System.out.println(e.toString());
		}
		Class myClass = null;
		try {
			myClass = loader.loadClass("ex02.pyrmont.PrimitiveServlet");
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}

		Servlet servlet = null;
		

		    RequestFacade requestFacade = new RequestFacade(request);     ResponseFacade responseFacade = new ResponseFacade(response);     try {       servlet = (Servlet) myClass.newInstance();       servlet.service((ServletRequest) requestFacade,

		        (ServletResponse) responseFacade);   

		try {
			servlet = (Servlet) myClass.newInstance();
			response.getWriter();
			servlet.service((ServletRequest) request, (ServletResponse) response);
		} catch (Exception e) {
			System.out.println(e.toString());
		} catch (Throwable e) {
			System.out.println(e.toString());
		}
	}
}
