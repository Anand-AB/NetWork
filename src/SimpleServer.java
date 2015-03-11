
// SimpleServer.java: A simple server program.
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class SimpleServer {
 public static void main(String args[]) throws IOException {
	 try {
		Scanner input=new Scanner(System.in);
		 System.out.println("Enter the message");
		 String msg=input.next();
		 
 // Register service on port 1254
 ServerSocket s = new ServerSocket(8880);
 Socket s1=s.accept(); // Wait and accept a connection
 // Get a communication stream associated with the socket
 OutputStream s1out = s1.getOutputStream();
 DataOutputStream dos = new DataOutputStream (s1out);
 // Send a string!
 dos.writeUTF(msg);
 // Close the connection, but not the server socket
 dos.close();
 s1out.close();
 s1.close();
 s.close();
 input.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
}