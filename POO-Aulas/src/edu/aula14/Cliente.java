package edu.aula14;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	public static void main(String[] args) {
		try {
			Socket server = new Socket("localhost", 20000);
			System.out.println("Conectado no servidor");
			
			Reader readerKbd = new InputStreamReader(System.in);
			Reader reader = new InputStreamReader(server.getInputStream());
			
			while (true) {
				if (readerKbd.ready()) { 
					int i = readerKbd.read();
					server.getOutputStream().write( i );
					server.getOutputStream().flush();
				}
				
				
				if (reader.ready()) { 
					System.out.print( (char) reader.read() );
				}
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
