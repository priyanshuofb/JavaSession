package com.ofb.javaSession;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws IOException {
		try {
			InetAddress ip = InetAddress.getByName("localhost");
			Socket sock = new Socket(ip, 5057);
			BufferedReader keyRead = new BufferedReader(new InputStreamReader(
					System.in));
			OutputStream ostream = sock.getOutputStream();
			PrintWriter pwrite = new PrintWriter(ostream, true);
			InputStream istream = sock.getInputStream();
			BufferedReader receiveRead = new BufferedReader(
					new InputStreamReader(istream));
			System.out.println("Hi");

			String receiveMessage, sendMessage;

			while (true) {
				sendMessage = keyRead.readLine();
				pwrite.println(sendMessage);
				pwrite.flush();
			       if((receiveMessage = receiveRead.readLine()) != null)  
			        {
			           System.out.println(receiveMessage);         
			        }         

				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
