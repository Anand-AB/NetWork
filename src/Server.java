import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) {
		System.out.print("Enter Server Socket Port to connect ::" );
		Scanner s1= new Scanner(System.in);
		int port = s1.nextInt();

		System.out.print("Enter Server IP Address to Connect ::" );
		String host = s1.next();
		
		System.out.print("Enter Message to Send ::" );
		String msg = s1.next();
		s1.close();

		try{
			System.out.println("Connecting to " + host + " on port " + port);
			
			Socket client = new Socket(host, port);
			System.out.println("Just connected to "+ client.getRemoteSocketAddress());
			
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
			
			out.write(msg.getBytes());
//			out.writeUTF(msg);
			
			outToServer.close();
			out.close();
			client.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
