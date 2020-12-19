package com.spring.webApps.WepAppsProject.Aspect;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionsHandler {
	
	@ExceptionHandler(value = ServiceException.class)
	public ModelAndView handleServiceException(){
		ModelAndView mav = new ModelAndView("exception");
		mav.addObject("cerror",new ServiceException());
		return mav; 
	}
	
	
	@ExceptionHandler(value = ConflictException.class)
	public ModelAndView handleConflictException(){
		ModelAndView mav = new ModelAndView("exception");
		mav.addObject("cerror",new ConflictException());
		return mav; 
	}
	
}