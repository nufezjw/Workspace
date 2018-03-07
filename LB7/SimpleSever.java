import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleSever {
	private static int PORT = 8765;
	public static void main(String[] args) throws IOException{
		ServerSocket listener =  new ServerSocket(PORT);//make a server object
		Socket client=listener.accept(); //wait for a connection adn create a client
		client.close();
	}
}
