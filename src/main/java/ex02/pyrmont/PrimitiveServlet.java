package ex02.pyrmont;

import javax.servlet.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class PrimitiveServlet implements Servlet {

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public void service(ServletRequest req, ServletResponse response) throws ServletException, IOException {

		System.out.println("from service");
		PrintWriter out = response.getWriter();
		out.println("Hello. Roses are red.");
		out.print("Violets are blue.");

	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void destroy() {
		System.out.println("destroy");

	}

	public static void main(String[] args) {
		/* Total number of processors or cores available to the JVM */
		System.out.println("Available processors (cores): " + Runtime.getRuntime().availableProcessors());

		/* Total amount of free memory available to the JVM */
		System.out.println("Free memory (bytes): " + Runtime.getRuntime().freeMemory());

		/* This will return Long.MAX_VALUE if there is no preset limit */
		long maxMemory = Runtime.getRuntime().maxMemory();
		/* Maximum amount of memory the JVM will attempt to use */
		System.out.println("Maximum memory (bytes): " + (maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory));

		/* Total memory currently available to the JVM */
		System.out.println("Total memory available to JVM (bytes): " + Runtime.getRuntime().totalMemory());

		/* Get a list of all filesystem roots on this system */
		File[] roots = File.listRoots();

		/* For each filesystem root, print some info */
		for (File root : roots) {
			
			System.out.println("File system root: " + root.getAbsolutePath());
			System.out.println("Total space (bytes): " + root.getTotalSpace());
			System.out.println("Free space (bytes): " + root.getFreeSpace());
			System.out.println("Usable space (bytes): " + root.getUsableSpace());
		}
	}

}
