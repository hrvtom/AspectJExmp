// Product.java
public class Product {
    public Product() {
		System.out.println("Product created");
    }

    public void configure() {
		System.out.println("Product configured");
    }

    static aspect FlagAccessViolation {
	pointcut factoryAccessViolation() 
	    : call(Product.new(..)) && !within(ProductFactory+);
	
	pointcut configuratorAccessViolation() 
	    : call(* Product.configure(..)) && !within(ProductFactory+);

	declare error 
	    :  factoryAccessViolation() || configuratorAccessViolation() 
	    : "Access control violation";
    }
}


