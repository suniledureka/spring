package co.edureka.pms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import co.edureka.pms.dto.Product;

public class ProductDAOImpl implements ProductDAO {
	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public Integer saveProduct(Product product) {
		String sql = "insert into product_dtls values(" + product.getProductId() + ",'" + product.getProductName()
				+ "'," + product.getProductPrice() + ")";
		int n = jt.update(sql);
		return n;
	}

	@Override
	public Product findProductById(Integer pid) {
		/*
		String sql = "select product_name, product_price from product_dtls where product_id=" + pid;		
		Product  product = null;
		try {
			product = jt.queryForObject(sql, new RowMapper<Product>() {

				@Override
				public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
					String pName = rs.getString(1);
					float pPrice = rs.getFloat(2);
					Product tempPro = new Product(pid, pName, pPrice);

					return tempPro;
				}
			});
		} catch (Exception ex) {}
		
		return product;
		*/
		
		//--- approach-2 to overcome SQL Injection		
		String sql = "select product_name, product_price from product_dtls where product_id = ?"; 		
		Product  product = null;
		try {
			product = jt.queryForObject(sql, new RowMapper<Product>() {

				@Override
				public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
					String pName = rs.getString(1);
					float pPrice = rs.getFloat(2);
					Product tempPro = new Product(pid, pName, pPrice);

					return tempPro;
				}
			}, new Object[] {pid});
		} catch (Exception ex) {}
		
		return product;		
	}

	@Override
	public Integer updateProduct(Integer pid, Product product) {
		String sql = "update product_dtls set product_name='" + product.getProductName() + "',product_price="
				+ product.getProductPrice() + " where product_id=" + pid;
		int n = jt.update(sql);
		return n;
	}

	@Override
	public Integer deleteProductById(Integer pid) {
		String sql = "delete from product_dtls where product_id=" + pid;
		int n = jt.update(sql);
		return n;
	}

	@Override
	public List<Product> findAll() {
		String sql = "select count(*) from product_dtls";
		int productsCount = jt.queryForObject(sql, Integer.class);
		System.out.println("no of products in stock = " + productsCount);
		
		
		sql = "select * from product_dtls";
		List<Product> products = jt.query(sql, new ResultSetExtractor<List<Product>>() {

			@Override
			public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Product> prods = new ArrayList<Product>();
				
				while(rs.next()) {
					int pid = rs.getInt(1);
					String pname = rs.getString(2);
					float pprice = rs.getFloat(3);
					
					Product prod = new Product(pid, pname, pprice);
					prods.add(prod);
				}
				return prods;
			}
			
		});
		
		return products;
	}

}
