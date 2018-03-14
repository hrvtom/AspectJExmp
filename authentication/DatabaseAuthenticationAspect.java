// DatabaseAuthenticationAspect.java
public aspect DatabaseAuthenticationAspect 
    extends AbstractAuthenticationAspect {

    public pointcut operationsNeeddingAuthentication():
	call(* DatabaseServer.connect());
}
