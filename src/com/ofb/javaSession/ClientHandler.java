package com.ofb.javaSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

class ClientHandler extends Thread {
	final Socket sock;
	final InputStream istream;
	final OutputStream ostream;
	final BufferedReader keyRead;
	final PrintWriter pwrite;

	public ClientHandler(Socket sock, InputStream istream, OutputStream ostream, BufferedReader keyRead, PrintWriter pwrite) {
		this.sock = sock;
		this.istream = istream;
		this.ostream = ostream;
		this.keyRead = keyRead;
		this.pwrite = pwrite;

	}

	@Override
	public void run() {
	      String receiveMessage, sendMessage;               
	      BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));

		while (true) {
			try {
			      {
			          if((receiveMessage = receiveRead.readLine()) != null)  
			          {
			             System.out.println(receiveMessage);         
			          }         
			          sendMessage = keyRead.readLine(); 
			          pwrite.println(sendMessage);             
			          pwrite.flush();
			        } 




			this.istream.close();
			this.ostream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	}
}
