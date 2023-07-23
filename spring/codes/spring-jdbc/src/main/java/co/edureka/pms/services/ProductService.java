package co.edureka.pms.services;

import co.edureka.pms.dto.Product;

public interface ProductService {
	public void saveProduct(Product product);
	
	public Product searchProductById(Integer pid);
	
	public void updateProduct(Integer pid, Product product);
	
	public void deleteProductById(Integer pid);
	
	public void findAll();
}
