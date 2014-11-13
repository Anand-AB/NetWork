import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Client extends Thread {

	public static void main(String[] args) {
		//Get Input for ServerSocket listening port
		System.out.print("Enter Server Socket Port ::" );
		Scanner s= new Scanner(System.in);
		int port = s.nextInt();
		try{
			Thread t = new Client(port);
			t.start();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	private ServerSocket serverSocket;

	public Client(int port) throws IOException{
		serverSocket = new ServerSocket(port);
	}

	public void run(){
		while(true){
			try{
				System.out.println("Waiting for connection on port " +
						serverSocket.getLocalPort() + "...");
				Socket server = serverSocket.accept();

				System.out.println("Just connected to "
						+ server.getRemoteSocketAddress());
				DataInputStream in = new DataInputStream(server.getInputStream());
				System.out.println(in.readUTF());

				DataOutputStream out = new DataOutputStream(server.getOutputStream());
				out.writeUTF("Thank you for connecting to "
						+ server.getLocalSocketAddress() + "\nGoodbye!");

				server.close();
			}catch(SocketTimeoutException s){
				System.out.println("Socket timed out!");
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}

}