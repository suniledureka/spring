package co.edureka.web.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	@RequestMapping("/welcome")
	public ModelAndView sendWelcomeMessage() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("msg", "Welcome to edureka!!");
		
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		String dateText = date.format(formatter);
		
		mav.addObject("today", dateText);
		
		mav.setViewName("index");
		
		return mav;
	}
}
