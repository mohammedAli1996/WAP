package com.spring.webApps.WepAppsProject.Car;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.spring.webApps.WepAppsProject.Aspect.ConflictException;
import com.spring.webApps.WepAppsProject.Aspect.ServiceException;
import com.spring.webApps.WepAppsProject.Parameters.ParametersService;
import com.spring.webApps.WepAppsProject.security.User;
import com.spring.webApps.WepAppsProject.security.UserRepository;

@Service
public class CarsService {

	@Autowired
	private CarRepository carRepo ; 
	
	@Autowired
	private ParametersService paramsService;  
	
	
	@Transactional
	public int addCar(CarModel car ) {
		try{
			if(car.getSeatsCount() == 0 ) {
				car.setSeatsCount(this.paramsService.getSeatsCount());
			}
			car.setVersion(1l);
			car.setCreatedAt(LocalDateTime.now().toString());
			this.carRepo.save(car);
			return 0 ; 
		}catch(Exception e){
			throw new ServiceException() ;
		}
	}
	
	
	public CarModel getById(int carId ) {
		Optional<CarModel> car = this.carRepo.findById(carId);
		if(car.isPresent()) {
			return car.get();
		}else {
			return null ; 
		}
	}
	
	
	public List<CarModel> getAll(){
		return this.carRepo.findAll(); 
	}
	
	public List<CarModel> getNonSelled(){
		List<CarModel> result = new ArrayList<CarModel>();
		for(CarModel car : this.carRepo.findAll()) {
			if(!car.isSelled()) {
				car.setSellPrice(car.getPrice() * this.paramsService.getPriceRatio());
				result.add(car);
			}
		}
		return result ; 
	}
	
	public List<CarModel> getSelled(){
		List<CarModel> result = new ArrayList<CarModel>();
		for(CarModel car : this.carRepo.findAll()) {
			if(car.isSelled()) {
				result.add(car);
			}
		}
		return result ; 
	}

	
	@Transactional
	public int updateCar(CarModel car ) {
		Optional<CarModel> optional = this.carRepo.findById(car.getId());
		if(optional.isPresent()) {
			if(car.getVersion() != optional.get().getVersion()) {
				throw new ConflictException();
			}
			CarModel carFromDb = optional.get();
			Long version = carFromDb.getVersion(); 
			version += 1l ; 
			carFromDb.setVersion(version);
			carFromDb.setCarName(car.getCarName());
			carFromDb.setClientName(car.getClientName());
			carFromDb.setDateOfBuy(car.getDateOfBuy());
			carFromDb.setPrice(car.getPrice());
			carFromDb.setSeatsCount(car.getSeatsCount());
			carFromDb.setSellPrice(car.getSellPrice());
			carFromDb.setUpdatedAt(LocalDateTime.now().toString());
			carFromDb.setModefiedBy(this.get_current_User().getUsername());
			this.carRepo.save(carFromDb);
			return 0 ;
		}else {
			throw new ServiceException() ; 
		}
	}
	
	@Transactional
	public int deleteCar(int carId ) {
		try {
			this.carRepo.deleteById(carId);
			return 0 ; 
		}catch(Exception e ) {
			throw new ServiceException() ; 
		}
	}
	
	
	public List<CarModel> getNotSelledCars(){
		List<CarModel> carsList = new ArrayList<CarModel>() ; 
		for(CarModel car : this.carRepo.findAll()) {
			if(car.getClientName().equalsIgnoreCase("none")) {
				carsList.add(car);
			}
		}
		return carsList ; 
	}
	
	@Transactional
	public int sellCar(CarModel car ) {
		Optional<CarModel> optional = this.carRepo.findById(car.getId());
		if(optional.isPresent()) {
			if(car.getVersion() != optional.get().getVersion()) {
				throw new ConflictException();
			}
			CarModel dbCar = optional.get();
			Long version = dbCar.getVersion(); 
			version += 1l ; 
			dbCar.setVersion(version);
			dbCar.setClientName(car.getClientName());
			dbCar.setSellPrice(this.paramsService.getPriceRatio() * car.getPrice());
			dbCar.setDateOfBuy(LocalDateTime.now().toString());
			dbCar.setSelled(true);
			this.carRepo.save(dbCar);
			return 0 ;
		}else {
			throw new ServiceException() ; 
		}
	}
	
	
	
	@Autowired
	private UserRepository userRepo ; 
	
	private User get_current_User() {
		String username ; 
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    Object principal =  auth.getPrincipal();
	    if(principal instanceof UserDetails) {
	    	username = ((UserDetails) principal).getUsername() ; 
		    for(User user : this.userRepo.findAll()) {
		    	if(user.getUsername().equalsIgnoreCase(username)) {
		    		return user ; 
		 		}
		 	}
	    }
	    return null  ; 
    }
	
}
