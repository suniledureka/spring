package co.edureka.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/library")
public class LibraryController {

 @GetMapping("/searchbook/{btitle}/{bauthor}")
 @ResponseBody
 public String findBookByTitleAndAuthor(@PathVariable("btitle") String bname, @PathVariable("bauthor") String author) {
	// write logic to check with DB
	String responseMsg = "<h2>Book with Title: " + bname + " || by Author: "+author +" is available now..</h2>";
	return responseMsg;
 }
}
