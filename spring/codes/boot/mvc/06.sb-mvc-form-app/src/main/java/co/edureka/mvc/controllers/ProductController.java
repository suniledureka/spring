package co.edureka.mvc.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProductController {
	
	@GetMapping(value = {"/","/entryform"})
	public String loadProductEntryForm() {
		return "index";
	}
	
	@PostMapping("/saveproduct")
	public String handleSubmitButtonClick(HttpServletRequest request, Model model) {
		Integer id = Integer.parseInt(request.getParameter("pid"));
		String name = request.getParameter("pname");
		Float price = Float.parseFloat(request.getParameter("pprice"));
		
		Map<String, Object> attributes = new HashMap<String, Object>();
		
		attributes.put("pid", id);
		attributes.put("pname", name);
		attributes.put("pprice", price);
		
		model.addAllAttributes(attributes);
		model.addAttribute("message", "Product Added to Catalog!!");
		
		return "success";
	}
}
