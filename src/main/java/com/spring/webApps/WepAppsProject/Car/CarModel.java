package com.spring.webApps.WepAppsProject.Car;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import java.io.Serializable;

@Entity
public class CarModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;

	@Version
	private Long version  = 1l ; 
	
	private String carName = "" ; 
	
	private int price = 0; 
	
	private int sellPrice  = 0 ;
	
	private int seatsCount   = 0 ; 
	
	private String dateOfBuy = ""; 
	
	private String clientName = "none";

	
	private String addedBy = ""; 
	
	private String createdAt = "" ;
	
	private String modefiedBy = ""; 
	
	private String updatedAt = "";
	
	private boolean selled = false ;

	public CarModel(int id, String carName, int price, int sellPrice, int seatsCount, String dateOfBuy, String clientName, String addedBy, String createdAt, String modefiedBy, String updatedAt, boolean selled) {
		this.id = id;
		this.carName = carName;
		this.price = price;
		this.sellPrice = sellPrice;
		this.seatsCount = seatsCount;
		this.dateOfBuy = dateOfBuy;
		this.clientName = clientName;
		this.addedBy = addedBy;
		this.createdAt = createdAt;
		this.modefiedBy = modefiedBy;
		this.updatedAt = updatedAt;
		this.selled = selled;
	}

	public CarModel() {}

	public CarModel(String carName, int price, int sellPrice, int seatsCount, String dateOfBuy, String clientName,
			String addedBy, String createdAt, String modefiedBy, String updatedAt, boolean selled) {
		this.carName = carName;
		this.price = price;
		this.sellPrice = sellPrice;
		this.seatsCount = seatsCount;
		this.dateOfBuy = dateOfBuy;
		this.clientName = clientName;
		this.addedBy = addedBy;
		this.createdAt = createdAt;
		this.modefiedBy = modefiedBy;
		this.updatedAt = updatedAt;
		this.selled = selled;
	}


	public boolean isSelled() {
		return selled;
	}

	public void setSelled(boolean selled) {
		this.selled = selled;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}

	public int getSeatsCount() {
		return seatsCount;
	}

	public void setSeatsCount(int seatsCount) {
		this.seatsCount = seatsCount;
	}

	public String getDateOfBuy() {
		return dateOfBuy;
	}

	public void setDateOfBuy(String dateOfBuy) {
		this.dateOfBuy = dateOfBuy;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}


	public String getAddedBy() {
		return addedBy;
	}


	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}


	public String getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}


	public String getModefiedBy() {
		return modefiedBy;
	}


	public void setModefiedBy(String modefiedBy) {
		this.modefiedBy = modefiedBy;
	}


	public String getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	} 
	
	
	
	
	
	
	
}
