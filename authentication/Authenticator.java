public class Authenticator {
    public static void authenticate() throws FailedException {
    }

    static public class FailedException extends RuntimeException {
	public FailedException(String message) {
	    super(message)
	}
    }
}
