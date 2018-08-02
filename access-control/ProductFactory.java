// ProductFactory.java
public class ProductFactory {

	public ProductFactory(){
		System.out.println("ProductFactory created");
	}
	
    public Product createProduct() {
		System.out.println("ProductFactory create Product");
		return new Product();
    }
    
    public void configureProduct(Product product) {
		System.out.println("ProductFactory configure Product");
		product.configure();
    }
}
