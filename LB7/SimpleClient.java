import java.io.IOException;
import java.net.Socket;

public class SimpleClient {
	private static int PORT = 8765;
	private static String server = "127.0.0.1";
	public static void main(String[] args) throws IOException{
		Socket socket = new Socket(server,PORT);
		socket.close();
	}
}
