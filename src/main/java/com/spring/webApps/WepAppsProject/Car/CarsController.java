package com.spring.webApps.WepAppsProject.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.webApps.WepAppsProject.Details.Details;
import com.spring.webApps.WepAppsProject.Parameters.ParametersService;


@RestController
public class CarsController {

	@Autowired
	private CarsService carService ; 

	@Autowired 
	private ParametersService paramsService ; 
	
	
	//get cars : all-sold-not sold
	@RequestMapping(method = RequestMethod.GET , value = "/cars/all")
	public ModelAndView getAllCars() {
		ModelAndView mav = new ModelAndView("cars/all");
	    mav.addObject("cars", this.carService.getAll());
		return mav ;
	}
	
	@RequestMapping(method = RequestMethod.GET , value = "/cars/notsold")
	public ModelAndView getnonSelled() {
		ModelAndView mav = new ModelAndView("cars/notsold");
		mav.addObject("cars", this.carService.getNonSelled());
	    return mav ;
	}
	
	@RequestMapping(method = RequestMethod.GET , value = "/cars/sold")
	public ModelAndView getSelled() {
		ModelAndView mav = new ModelAndView("cars/sold");
		mav.addObject("cars", this.carService.getSelled());
	    return mav ;
	}
	
	
	//sell car 
	@RequestMapping(method = RequestMethod.GET , value = "/cars/sell/{id}")
	public ModelAndView sellCargGet(@PathVariable int id ){
		ModelAndView mav = new ModelAndView("cars/sell");
		CarModel carModel = this.carService.getById(id);
		carModel.setSellPrice(carModel.getPrice() * paramsService.getPriceRatio());
	    mav.addObject("car",carModel);
	    return mav ;
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/cars/sell")
	public ModelAndView sellCar(@ModelAttribute CarModel car ){
		this.carService.sellCar(car);
		return this.getSelled();
	}
	//

	
	
	//add car
	
	@RequestMapping(method = RequestMethod.GET , value = "/cars/add")
	public ModelAndView addGet() {
		ModelAndView mav = new ModelAndView("cars/add");
	    mav.addObject("car",new CarModel());
	    return mav ;
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/cars/save")
    public ModelAndView SaveCar(@ModelAttribute CarModel car ) {
        this.carService.addCar(car);
        return getAllCars(); 
    }
	
	//
	
	
	//update car 
	
	@RequestMapping(method = RequestMethod.GET , value = "/cars/update/{id}")
	public ModelAndView updateCar(@PathVariable int id ){
		ModelAndView mav = new ModelAndView("cars/update");
	    mav.addObject("car",this.carService.getById(id));
	    return mav ;
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/cars/update")
    public ModelAndView update(@ModelAttribute CarModel car ) {
        this.carService.updateCar(car);
        return getAllCars(); 
    }
	
	//
	
	
	//delete car
	@RequestMapping(method = RequestMethod.GET , value = "/cars/del/{id}")
	public ModelAndView deleteCar(@PathVariable int id ){
		try {
			this.carService.deleteCar(id);
		}catch(Exception e ) {}
		return this.getAllCars() ;
	}
	//
	
	
	
	@RequestMapping(method = RequestMethod.GET , value = "/export/view")
	public ModelAndView exportSettings(){
		ModelAndView mav = new ModelAndView("export");
		mav.addObject("export", new Details());
		return mav ; 
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/export/send")
	public ModelAndView export(@ModelAttribute Details details ){
		this.carService.export(details);
		return getAllCars();
	}
	
	
}
