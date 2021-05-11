import java.io.*; //importing this, it let us use input and output functions
import java.net.*; //it provides the classes for implementing networking applications

public class client {

	public static void main(String[] args) {
		System.out.println("\n\n\n----------CHATBOX: Client----------");
		
		try {
			
			Socket s = new Socket("192.168.254.113",9090); //client here is connecting to the server with ip address and port number as parameters
			System.out.println("[Status]: Client has Successfully Connected");
			
			DataInputStream din = new DataInputStream(s.getInputStream()); //creates an object that will be used in receiving message from the server
			DataOutputStream dout = new DataOutputStream(s.getOutputStream()); //creates an object that will be used in sending message to the server
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //creates buffered reader obj to be used for scanning messages in the chat
			
			String msgin = "", msgout = ""; //string variables to be used in holding the messages
			
			System.out.println("--------------[CHATBOX]--------------");
			while (!msgin.equals("end")) { //loop condition
				
				System.out.print("[Client]: ");
				msgout = br.readLine(); //reads client message and store it in msgout string variable 
				dout.writeUTF(msgout); //sends the message to the server
				
				msgin = din.readUTF(); //reads the message from the server
				System.out.println("[Server]: "+msgin); //prints the message from the server
	
			}
			
			s.close(); //closes the socket
			
			
		} catch (Exception e) {
			System.out.println(e); //handling exception by printing the exception
		}
		
		
		
		
	}

}
