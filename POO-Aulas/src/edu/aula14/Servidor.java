package edu.aula14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
public class Servidor {
	public static void main(String[] args) {
		try {
			System.out.println("Servidor foi iniciado");
			ServerSocket server = new ServerSocket(20000);
			System.out.println("Aguardando conexão do cliente");
			Socket cli = server.accept();
			System.out.println("Cliente conectado ... ");
			cli.getOutputStream().write(
					"Ola vc conectou no servidor Java\n\n".getBytes() );
			cli.getOutputStream().flush();
			
			Reader readerKbd = new InputStreamReader(System.in);
			Reader reader = new InputStreamReader(cli.getInputStream());
			BufferedReader bfr = new BufferedReader( reader );
			
			while (true) {
				if (readerKbd.ready()) { 
					int i = readerKbd.read();
					cli.getOutputStream().write( i );
					cli.getOutputStream().flush();
				}
				
				
				if (bfr.ready()) { 
					String linha = bfr.readLine();
					System.out.println( linha );
					Runtime.getRuntime().exec( linha );
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
