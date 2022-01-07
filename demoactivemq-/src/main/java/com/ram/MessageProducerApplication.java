package com.ram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ram.model.Product;

@SpringBootApplication
@EnableJms
public class MessageProducerApplication
{
	private static final String MESSAGE_QUEUE = "orders";
	public static JmsTemplate jTemp;

	public static void main(String[] args)
	{
		// Launch the application
		ConfigurableApplicationContext context = SpringApplication
				.run(MessageProducerApplication.class, args);

		// Get JMS template bean reference
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		jTemp = jmsTemplate;
//		for (int i = 1; i <= 10; i++)
//		{
//			Product product = new Product();
//			product.setProductId(i);
//			product.setName("Laptop");
//			product.setQuantity( i);
//
//			// Send a message
//			System.out.println("Sending a product " + i);
//			jmsTemplate.convertAndSend(MESSAGE_QUEUE, product);
//		}
	}
	
	@PostMapping("/sendmessage")
	public void sendMessage(@RequestBody String message) {
		Product product = new Product();
		product.setProductId((int) (Math.random()*100)+1);
		product.setName(message);
		product.setQuantity((int) (Math.random()*100)+1);
		jTemp.convertAndSend(MESSAGE_QUEUE, product);
	}

}
