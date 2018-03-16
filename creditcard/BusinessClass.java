import java.util.Random;

public class BusinessClass{
	
	private Random rnd = new Random();
	private int currentStatus = 1000;
	
	public static void main(String[] args){
		BusinessClass bc = new BusinessClass();
		
		bc.load();
		bc.performSomeOperation("333-444-555",new Integer(250));
		bc.save();
	}
	
	public void performSomeOperation(String creditCard, Integer value) throws InvalidBusinesException{
		System.out.println("Some operation performed with credit card "+creditCard+", deposit decreased by "+value+"$");
	}
	
	public void load() throws InvalidBusinesException {
		
		if(rnd.nextBoolean()){
			System.out.println("Status loaded");
		}else{
			throw new InvalidBusinesException("Can't load current deposit status");
		}
		
	}
	
	public void save() throws InvalidBusinesException {
		if(rnd.nextBoolean()){
			System.out.println("New status saved");
		}else{
			throw new InvalidBusinesException("Can't save current deposit status");
		}

	}
	
	
}

	