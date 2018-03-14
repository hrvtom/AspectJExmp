// AbstratcAuthenticationAspect.java
public abstract aspect AbstractAuthenticationAspect {
    public abstract pointcut operationsNeeddingAuthentication();

    before() : operationsNeeddingAuthentication() {
	// Perform authentication. If could not be authenticated,
	// let the exception thrown by authenticate propagate
	Authenticator.authenticate();
    }
}
