package co.edureka.pms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.edureka.pms.dao.ProductDAO;
import co.edureka.pms.dto.Product;

public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDAO dao;
	
	@Override
	public void saveProduct(Product product) {
		int n = dao.saveProduct(product);
		if(n > 0)
			System.out.println("Product Saved to Stock");
		else
			System.out.println("Internal Error.. Try Again");
	}

	@Override
	public Product searchProductById(Integer pid) {		
		return dao.findProductById(pid);
	}

	@Override
	public void updateProduct(Integer pid, Product product) {
		int n = dao.updateProduct(pid,product);
		if(n > 0)
			System.out.println("Product Updated in Stock");
		else
			System.err.println("No Matching Product Found in Stock to Update");

	}

	@Override
	public void deleteProductById(Integer pid) {
		int n = dao.deleteProductById(pid);
		if(n > 0)
			System.out.println("Product deleted from Stock");
		else
			System.err.println("No Matching Product to Delete!!");
	}

	@Override
	public void findAll() {
		List<Product> products = dao.findAll();
		for(Product prod : products) {
			System.out.println(prod);
			try {
				Thread.sleep(1000);
			}catch(Exception ex) {}
		}
	}

}
