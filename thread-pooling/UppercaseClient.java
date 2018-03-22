import java.io.*;
import java.net.*;

public class UppercaseClient{
	public static void main(String[] args) throws IOException{
		if(args.length !=2){
		System.out.println("Usage: UppercaseClient <server> <portNum>");
		System.exit(1);
		}
		
		String serverName = args[0];
		int portNum = Integer.parseInt(args[1]);
		
		Socket requestSocket = new Socket(serverName, portNum);
		
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedReader responseReader = new BufferedReader(new InputStreamReader(requestSocket.getInputStream()));
		Writer requestWriter = new OutputStreamWriter(requestSocket.getOutputStream());
		
		while(true){
			System.out.println("Type a string to convert");
			String requestString = consoleReader.readLine();
			if (requestString.equals("END"))
				break;
			requestWriter.write(requestString+"\n");
			requestWriter.flush();
			System.out.println("Request: "+requestString);
			System.out.println("Response: "+responseReader.readLine());		
		}
	}
}
