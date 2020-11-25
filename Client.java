package rmi.task;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
	public Client() throws IOException {
		Socket s = null;
		try {
			s = new Socket("localhost", 51_000);
			System.out.println("Sunucuya baðlanýldý.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		FileInputStream fs = new FileInputStream("res/img.png");
		DataOutputStream ds = new DataOutputStream(s.getOutputStream());
		
		int size = -1;
		byte[] _64bit = new byte[8];
		while ((size = fs.read(_64bit)) > -1)
			ds.write(_64bit, 0, size);
		ds.flush();
		System.out.println("Baðlantý kapatýlýyor.");

		fs.close();
		ds.close();
		s.close();

	}

	public static void main(String[] args) throws IOException {
		new Client();

	}
}
