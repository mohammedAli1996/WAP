package com.spring.webApps.WepAppsProject.Parameters;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.webApps.WepAppsProject.Aspect.ServiceException;

@Service
public class ParametersService {

	@Autowired
	private ParametersRepository paramsRepo ; 
	
	
	@PostConstruct 
	private void defaults() {
		if(this.paramsRepo.count() == 0 ) {
			Parameters params = new Parameters() ; 
			params.setDefaultSeatsCount(4);
			params.setSellPriceRatio(10);
			this.paramsRepo.save(params);
		}
	}
	
	public int getSeatsCount() {
		return this.paramsRepo.findAll().get(0).getDefaultSeatsCount();		
	}
	
	public int getPriceRatio() {
		return this.paramsRepo.findAll().get(0).getSellPriceRatio();
	}
	
	public int setDefaultSeatsCount(int seatsCount ) {
		try {
			Parameters param = this.paramsRepo.findAll().get(0);
			param.setDefaultSeatsCount(seatsCount);
			this.paramsRepo.save(param);
			return 0 ; 
		}catch(Exception e ) {
			throw new ServiceException();
		}
	}
	
	public int setDefaultsellingRatio(int sellingRatio ) {
		try {
			Parameters param = this.paramsRepo.findAll().get(0);
			param.setSellPriceRatio(sellingRatio);
			this.paramsRepo.save(param);
			return 0 ; 
		}catch(Exception e ) {
			throw new ServiceException();
		}
	}

	public Parameters getCurrConfig() {
		return this.paramsRepo.findAll().get(0);
	}
	
}
