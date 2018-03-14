// JapaneseMannersAspect.java
public aspect JapaneseMannersAspect {
    pointcut callSayMessageToPerson(String person) 
	: call(* HelloWorld.sayToPerson(String, String))
	       && args(*, person);

    void around(String person) 
	: callSayMessageToPerson(person) {
	proceed(person + "-san");
    }
}
