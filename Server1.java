package rmi.task;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {

	public Server1() {
		try {
			ServerSocket ss = new ServerSocket(51_000);
			Socket s = ss.accept();
			
			System.out.println("Ýstemciye baðlanýldý.");
			
			FileOutputStream fs = new FileOutputStream("res/proc-img.png");
			DataInputStream ds = new DataInputStream(s.getInputStream());
			
			int size = -1;
			byte[] _64bit = new byte[8];
			while ((size = ds.read(_64bit)) > -1)
				fs.write(_64bit, 0, size);
			fs.flush();
			System.out.println("Baðlantý kapatýlýyor.");
			fs.close();
			ds.close();
			s.close();
			ss.close();
		} catch (IOException e) {
			//System.out.println("Ýstemciye baðlanýrken veya ");
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws IOException {
		new Server1();
		
	}
}
