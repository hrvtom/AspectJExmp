import java.util.Random;
public class Authenticator {
    public static void authenticate() throws FailedException {
		Random rnd = new Random();
		if(rnd.nextBoolean()){
		System.out.println("Succesfully authenticated");
		}else{
			throw new FailedException("Authentication Failed, access not granted");
		}
		
    }

    static public class FailedException extends RuntimeException {
	public FailedException(String message) {
	    super(message);
	}
    }
}
