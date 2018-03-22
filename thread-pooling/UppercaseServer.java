import java.io.*;
import java.net.*;

public class UppercaseServer{
	
	public static void main(String[] args)throws Exception{
		if (args.length != 1){
			System.out.println("Usage: UppercaseServer <portnumber>");
			System.exit(1);
		}
		
		int portNum = Integer.parseInt(args[0]);
		ServerSocket serverSocket = new ServerSocket(portNum);
		
		while(true){
			Socket requestSocket = serverSocket.accept();
			Thread serverThread = new Thread(new UppercaseWorker(requestSocket));
			serverThread.start();
		}
	}
	
	static class UppercaseWorker implements Runnable{
		private Socket _requestSocket;
		
		public UppercaseWorker(Socket requestSocket) throws IOException{
			System.out.println("creaing new UppercasewWorker");
			_requestSocket = requestSocket;
		}
		
		public void run(){
			BufferedReader requestReader = null;
			Writer responseWriter = null;
			
			try{
				requestReader = new BufferedReader(new InputStreamReader(_requestSocket.getInputStream()));
				responseWriter = new OutputStreamWriter(_requestSocket.getOutputStream());
				while(true){
					String requestString = requestReader.readLine();
					if(requestString == null)
						break;
					responseWriter.write(requestString.toUpperCase()+"\n");
					responseWriter.flush();
				}
			}catch (IOException e){
				System.out.println("Shit happens "+ e);
			}finally{
				try{
				if(requestReader != null)
					requestReader.close();
				if(responseWriter != null)
					responseWriter.close();
				_requestSocket.close();
				}catch (IOException e){
					System.out.println("Problem releasing resources " + e);
				}
			}
			System.out.println("Ending the session");
		}
	}
	
	
	
}
