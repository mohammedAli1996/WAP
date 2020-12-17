package com.spring.webApps.WepAppsProject.Parameters;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Parameters {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
	
	private int defaultSeatsCount ; 
	
	private int sellPriceRatio ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDefaultSeatsCount() {
		return defaultSeatsCount;
	}

	public void setDefaultSeatsCount(int defaultSeatsCount) {
		this.defaultSeatsCount = defaultSeatsCount;
	}

	public int getSellPriceRatio() {
		return sellPriceRatio;
	}

	public void setSellPriceRatio(int sellPriceRatio) {
		this.sellPriceRatio = sellPriceRatio;
	}

	public Parameters(int id, int defaultSeatsCount, int sellPriceRatio) {
		this.id = id;
		this.defaultSeatsCount = defaultSeatsCount;
		this.sellPriceRatio = sellPriceRatio;
	}
	
	public Parameters() {}
	
	
	
}
