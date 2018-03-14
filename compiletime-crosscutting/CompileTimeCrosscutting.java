aspect CompileTimeCrosscutting {
    pointcut callToDangerousCode() : call(* ThirdParty.dangerous());
    pointcut callToBlockingOperations() : call(* ThirdParty.blocking());

    declare error : callToDangerousCode()
	: "This third-party code is known to result in crash";

    declare warning : callToBlockingOperations() 
	: "Please ensure you are not calling this from AWT thread";

    before() : callToBlockingOperations() {
	System.out.println("Going to block");
    }
}

public class Illustration {
    public static void main(String[] args) {
	ThirdParty tpc = new ThirdParty();
	tpc.blocking();
	tpc.dangerous();
    }
}

class ThirdParty {
    public void blocking() {
	System.out.println("Blocking");
    }

    public void blocking2() {
	System.out.println("Blocking");
    }

    public void dangerous() {
    }
}
