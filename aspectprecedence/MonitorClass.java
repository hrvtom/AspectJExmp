public class MonitorClass{
	
	public MonitorClass(){
	}
	
	public void printout(){
		System.out.println("      MonitorClass printout");
	}
	
	
	public void printout2(){
		System.out.println("      MonitorClass printout2");
	}
	
	public static void main(String[] args){
		MonitorClass monitor = new MonitorClass();
		
		monitor.printout();
		System.out.println("\\n \\n");
		monitor.printout2();
	}
	
}