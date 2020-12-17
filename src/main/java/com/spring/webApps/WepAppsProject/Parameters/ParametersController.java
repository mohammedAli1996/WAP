package com.spring.webApps.WepAppsProject.Parameters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class ParametersController {

	@Autowired 
	private ParametersService paramsService ; 
	
	@RequestMapping(method = RequestMethod.GET , value = "/params/view")
	public ModelAndView getParams() {
		ModelAndView mav = new ModelAndView("params/view");
	    mav.addObject("params", this.paramsService.getCurrConfig());
		return mav ;
	}
	
	@RequestMapping(method = RequestMethod.GET , value = "/params/update")
	public ModelAndView updateParams() {
		ModelAndView mav = new ModelAndView("params/update");
	    mav.addObject("params", this.paramsService.getCurrConfig());
		return mav ;
	}
	
	
	@RequestMapping(method = RequestMethod.POST , value = "/params/set")
	public ModelAndView setParams(@ModelAttribute Parameters param ){
		return getParams();
	}
	
}
