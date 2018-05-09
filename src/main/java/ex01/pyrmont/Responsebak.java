package ex01.pyrmont;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Responsebak {

	public static void main(String[] args) {

		Socket socket = new Socket();
		InetSocketAddress bindpoint = new InetSocketAddress("127.0.0.1", 8080);

		try {

			socket.bind(bindpoint);
			socket.connect(bindpoint, 5000);
			OutputStream os = socket.getOutputStream();
			boolean autoflush = true;
			PrintWriter out = new PrintWriter(socket.getOutputStream(), autoflush);

			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// send an HTTP request to the web server
			out.println("GET /index.html HTTP/1.1");
			out.println("Host: localhost:8080");
			out.println("Connection: Close");
			out.println(-1);

			// read the response
			boolean loop = true;

			StringBuffer sb = new StringBuffer(8096);
			while (loop) {
				if (in.ready()) {
					int i = 0;

					while (i != -1) {
						i = in.read();
						sb.append((char) i);
						System.out.print((char) i);
						out.println(-1);
						Thread.currentThread().sleep(50);
					}
					loop = false;
				}
				
			}

			// display the response to the out console
			System.out.println(sb.toString());
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
