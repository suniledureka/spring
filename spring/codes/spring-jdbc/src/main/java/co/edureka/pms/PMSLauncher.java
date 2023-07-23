package co.edureka.pms;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.edureka.pms.dto.Product;
import co.edureka.pms.services.ProductService;

public class PMSLauncher {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		//initialize spring container
		ApplicationContext context = new ClassPathXmlApplicationContext("product-beans.xml");
		
		//get the Product Service bean reference
		ProductService service = (ProductService)context.getBean("product-service");
		
		Product product;
		int pid;
		
		while(true) {
			System.out.println("1. New Product");
			System.out.println("2. Search Product");
			System.out.println("3. Update Product");
			System.out.println("4. Delete Product");
			System.out.println("5. All Products");
			System.out.println("6. Exit");
			
			System.out.print("\nenter an option: ");
			int opt = sc.nextInt();
			
			switch(opt) {
			 case 1:
				product = productEntry();
				service.saveProduct(product);
				break;
			 case 2:
				System.out.print("enter product id to be searched for: ");
				pid = sc.nextInt();
				product = service.searchProductById(pid);
				if(product != null)
					System.out.println(product);
				else
					System.err.println("No Matching Product with Product ID: " + pid);
				break;
			 case 3:
				 System.out.println("implement product update logic");
				break;
			 case 4:
				System.out.print("enter product id to delete: ");
				pid = sc.nextInt();
				service.deleteProductById(pid);
				break;
			 case 5:
				 service.findAll();
				break;
			 case 6:
				System.out.println("---- application designed & developed by team@edureka ----");
				System.exit(0);
				break;
			 default:
				System.err.println("INVALID OPTION-----TRY AGAIN"); 
				break;				
			}
			System.out.println("================================================================================");
		}//while
	}//main

	private static Product productEntry() {
		System.out.print("enter product id: ");
		int pid=sc.nextInt();
		sc.nextLine();
		
		System.out.print("enter product name: ");
		String pname = sc.nextLine();
		
		System.out.print("enter product price: ");
		float pprice = sc.nextFloat();
		
		Product prod = new Product();
		prod.setProductId(pid);
		prod.setProductName(pname);
		prod.setProductPrice(pprice);
		
		return prod;
	}
}
