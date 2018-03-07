import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DataServer {
	private static int PORT = 8765;
	private static Socket client;
	private static ServerSocket listener;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			listener=new ServerSocket(PORT);
			client=listener.accept();
			PrintWriter out = new PrintWriter(client.getOutputStream(),true); //send a message from the server to the client	
			while(true) {
				out.println((new Date()).toString());
				Thread.sleep(500);
			}
		}catch(Exception e) {
			System.out.println(e);
		}finally {
				try {
					client.close();
					listener.close();
				}catch(IOException e) {}
		}
	}

}
