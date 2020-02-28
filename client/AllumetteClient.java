package client;

import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class AllumetteClient {

	public static void main(String[] args) {
		Socket s = null;
		InputStream is = null;
		OutputStream os = null;
		byte[] b = new byte[1024];

		try {
			s = new Socket("localhost", 12345);
			is = s.getInputStream();
			os = s.getOutputStream();	
		
			is.read(b);
			System.out.println(new String(b));
		}
		catch (IOException e) {
			System.out.println("[ERROR] - " + e.getMessage());
		}
		finally {
			try {
				if (os != null)
					os.close();
			}
			catch (IOException e) {
				System.out.println("[ERROR] - " + e.getMessage());
			}
			try {
				if (is != null)
					is.close();
			}
			catch (IOException e) {
				System.out.println("[ERROR] - " + e.getMessage());
			}
			try {
				if (s != null)
					s.close();
			}
			catch (IOException e) {
				System.out.println("[ERROR] - " + e.getMessage());
			}
		}
	}

}
