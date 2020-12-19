package com.spring.webApps.WepAppsProject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {

	
	@RequestMapping(method = RequestMethod.GET , value = "/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		return mav ; 
	}
	
	
	@RequestMapping(method = RequestMethod.GET , value = "/login")
    public ModelAndView login() {
    	ModelAndView mav = new ModelAndView("login");
    	return mav; 
    }
    
}
