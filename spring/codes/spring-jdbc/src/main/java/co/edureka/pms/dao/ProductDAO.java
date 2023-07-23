package co.edureka.pms.dao;

import java.util.List;

import co.edureka.pms.dto.Product;

public interface ProductDAO {
	public Integer saveProduct(Product product);
	
	public Product findProductById(Integer pid);
	
	public Integer updateProduct(Integer pid, Product product);
	
	public Integer deleteProductById(Integer pid);
	
	public List<Product> findAll();
}
