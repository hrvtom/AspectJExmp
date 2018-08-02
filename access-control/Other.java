public class Other {
	
	public static void main(String[] strArgs){
		Other other = new Other();
		other.work();

	}
	
	public Other(){
		System.out.println("Other created");
	}
	
	public void work(){
		// this access is not allowed by aspect 
		// source code can't compile
		// Product product = new Product();
		// product.configure();
	
		ProductFactory productFactory = new ProductFactory();
		Product product2 = productFactory.createProduct();
		productFactory.configureProduct(product2);
	}
}
