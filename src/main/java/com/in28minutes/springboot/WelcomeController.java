package com.in28minutes.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@Autowired
	private WelcomeService service;
	@RequestMapping("/hello")
	public String welcome() {
		return service.retrieveMessage();
		
	}
	@Component
	public class WelcomeService{
		
		public String retrieveMessage() {
			 return "GoodMorning Users";
		}
		
	}

}
