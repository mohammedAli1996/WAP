package com.spring.webApps.WepAppsProject.Car;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.webApps.WepAppsProject.Parameters.ParametersService;

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
			car.setCreatedAt(LocalDateTime.now().toString());
			this.carRepo.save(car);
			return 0 ; 
		}catch(Exception e){
			return 1 ;
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
			CarModel carFromDb = optional.get(); 
			carFromDb.setCarName(car.getCarName());
			carFromDb.setClientName(car.getClientName());
			carFromDb.setDateOfBuy(car.getDateOfBuy());
			carFromDb.setPrice(car.getPrice());
			carFromDb.setSeatsCount(car.getSeatsCount());
			carFromDb.setSellPrice(car.getSellPrice());
			carFromDb.setUpdatedAt(LocalDateTime.now().toString());
			this.carRepo.save(carFromDb);
			return 0 ;
		}else {
			return 1 ; 
		}
	}
	
	@Transactional
	public int deleteCar(int carId ) {
		try {
			this.carRepo.deleteById(carId);
			return 0 ; 
		}catch(Exception e ) {
			return 1 ; 
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
			CarModel dbCar = optional.get(); 
			dbCar.setClientName(car.getClientName());
			dbCar.setSellPrice(this.paramsService.getPriceRatio() * car.getPrice());
			dbCar.setDateOfBuy(LocalDateTime.now().toString());
			this.carRepo.save(dbCar);
			return 0 ;
		}else {
			return 1 ; 
		}
	}
	
}
