package com.spring.webApps.WepAppsProject.MQ;


        import com.fasterxml.jackson.databind.ObjectMapper;
        import com.spring.webApps.WepAppsProject.Car.CarModel;
        import com.spring.webApps.WepAppsProject.Details.Details;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.amqp.rabbit.core.RabbitTemplate;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

@Service
public class OrderMessageSender {
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;
    private static final Logger log = LoggerFactory.getLogger(OrderMessageSender.class);
    @Autowired
    public OrderMessageSender(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendOrderCar(CarModel carModel) {
        this.rabbitTemplate.convertAndSend("CarQueue", carModel);
        log.info("Car Sent");
    }
    public void sendOrderdetails(Details details) {
        this.rabbitTemplate.convertAndSend("DetailsQueue", details);
        log.info("Details Sent");
    }


}