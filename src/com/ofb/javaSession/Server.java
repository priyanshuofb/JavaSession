package com.ofb.javaSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket sersock = new ServerSocket(5057);


		while (true) {

			try {
				Socket sock = sersock.accept();

				System.out.println("Hi");
				BufferedReader keyRead = new BufferedReader(
						new InputStreamReader(System.in));
				OutputStream ostream = sock.getOutputStream();
				PrintWriter pwrite = new PrintWriter(ostream, true);

				// receiving from server ( receiveRead object)
				InputStream istream = sock.getInputStream();

				Thread t = new ClientHandler(sock, istream, ostream, keyRead,
						pwrite);
				t.start();

			} catch (Exception e) {
				sersock.close();
				e.printStackTrace();
			}
		}
	}
}
