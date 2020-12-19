package com.spring.webApps.WepAppsProject;

import com.spring.webApps.WepAppsProject.Car.CarModel;
import com.spring.webApps.WepAppsProject.Details.Details;
import com.spring.webApps.WepAppsProject.MQ.OrderMessageSender;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableRabbit
@EnableCaching
public class WepAppsProjectApplication implements CommandLineRunner {
 @Autowired
 OrderMessageSender orderMessageSender;
	public static void main(String[] args) {
		SpringApplication.run(WepAppsProjectApplication.class, args);



	}

	@Override
	public void run(String... args) throws Exception {
		Details details = new Details("123","456");
		CarModel carModel= new CarModel("String carName", 2, 2, 3, "String dateOfBuy", "String clientName",
				"String addedBy", "String createdAt", "String modefiedBy", "String updatedAt", true);
		orderMessageSender.sendOrderCar(carModel);
		orderMessageSender.sendOrderdetails(details);
	}
}
