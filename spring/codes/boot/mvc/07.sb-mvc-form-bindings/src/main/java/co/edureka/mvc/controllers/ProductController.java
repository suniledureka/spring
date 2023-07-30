package co.edureka.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import co.edureka.mvc.bindings.Product;

@Controller
public class ProductController {
	
	@GetMapping(value = {"/","/entryform"})
	public String loadProductEntryForm(Model model) {
		Product emptyProduct = new Product();
		
		model.addAttribute("product", emptyProduct);
		
		return "index";
	}
	
	@PostMapping("/saveproduct")
	public String handleSubmitButtonClick(Product product, Model model) {
		System.out.println(product);
		
		model.addAttribute("prod", product);
		
		
		//return "success";
		return "redirect:/productsaved";
	}
	
	@GetMapping("/productsaved")
	public String productSaved(Model model) {
		model.addAttribute("message", "Product Added to Catalog!!");
		return "success";
	}
}
