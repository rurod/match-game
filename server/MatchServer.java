package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

import server.MatchGame;

public class MatchServer {

	public static void main(String[] args) {
		ServerSocket ss = null;

		try {
			ss = new ServerSocket(12345);
			System.out.println("[LOG] - Server started - Waiting for connections ...");
			while (true) {
				MatchGame mg = new MatchGame(ss.accept());
				Thread t = new Thread(ag);
				t.start();
				System.out.println("[LOG] - A connection has been made - Thread created");
			}
			
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if (ss != null) {
				try {	
					ss.close();
				}
				catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
	}

}
