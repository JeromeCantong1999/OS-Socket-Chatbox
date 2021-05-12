/* CANTONG, Jerome E.
 * CARANGAN, Ella Grace S.
 * CENIZA, Rhendon M.
 * 
 * CPE-2D
 * */

import java.io.*; //importing this, it let us use input and output functions
import java.net.*; //it provides the classes for implementing networking applications

public class server {

	public static void main(String[] args) { 
		System.out.println("\n\n\n----------CHATBOX: Server----------");
		
		try {
			
			System.out.println("[Status]: Waiting for Client to Connect.....");
			ServerSocket ss = new ServerSocket(9090); //creates a server socket object with port number as parameter
			Socket s = ss.accept(); //creates a socket that will accept clients that wants to connect
			System.out.println("[Status]: Client has Successfully Connected");
			
			DataInputStream din = new DataInputStream(s.getInputStream()); //creates an object that will be used in receiving message from the client
			DataOutputStream dout = new DataOutputStream(s.getOutputStream()); //creates an object that will be used in sending message to the client
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //creates buffered reader obj to be used for scanning messages in the chat
			
			String msgin="", msgout=""; //string variables to be used in holding the messages
			
			
			System.out.println("--------------[CHATBOX]--------------");
			while (!msgin.equals("end")) { //as long as the chat message is not end, the loop will not terminate
				
				msgin = din.readUTF(); //receives message from the client 
				System.out.println("[Client]: "+msgin); //prints the message
				
				System.out.print("[Server]: ");
				msgout = br.readLine();  //scans a message to be send to client
				dout.writeUTF(msgout);; //sends message to the client
				
				dout.flush(); //buffered output will be fluhed
			}
			
			s.close(); //closes the socket
			
		} catch (Exception e)	{		
			System.out.println(e); //handles exception by printing the exception
		}
		
		
	}

}
