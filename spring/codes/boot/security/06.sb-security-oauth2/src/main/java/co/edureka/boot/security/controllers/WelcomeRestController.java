package co.edureka.boot.security.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
 @GetMapping("/welcome")
 public String showWelcomeMessage(Authentication auth) {
   System.out.println(auth);
   System.out.println(auth.getPrincipal());
   return "Welcome to Oauth2 Implementation";
 }
}
