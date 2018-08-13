public abstract class A{
	private int x;
	private int y;
	
	public static void main(String[] args){
		Sum s = new Sum(2,4);
		Multi m = new Multi(3,5);
		
		println("Sum of "+s.getX()+" and "+s.getY()+" is "+s.sum());
		println("Multi of "+m.getX()+" and "+m.getY()+" is "+m.multi());
		
	}
	
	public static void println(String s){
		System.out.println(s);
	}
	
	public A(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	
}