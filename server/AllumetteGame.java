package server;

import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class AllumetteGame implements Runnable {

	private Socket s = null;
	private InputStream is = null;
	private OutputStream os = null;

	public AllumetteGame(Socket s) {
		this.s = s;
	}

	public void getStreams() throws IOException {
		this.is = this.s.getInputStream();
		this.os = this.s.getOutputStream();
	}

	public void play() throws IOException {
		this.os.write("Hello".getBytes());
	}

	public void run() {
		try {
			this.getStreams();
			this.play();
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		} 	
	}

}	
