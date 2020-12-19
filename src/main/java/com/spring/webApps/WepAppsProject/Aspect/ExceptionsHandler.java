package com.spring.webApps.WepAppsProject.Aspect;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionsHandler {
	
	@ExceptionHandler(value = ServiceException.class)
	public ModelAndView handleServiceException(){
		System.out.println("not found invoked ");
		ModelAndView mav = new ModelAndView("exception");
		mav.addObject("cerror",new ServiceException());
		return mav; 
	}
	
}