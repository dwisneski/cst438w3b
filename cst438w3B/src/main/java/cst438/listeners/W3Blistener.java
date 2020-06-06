package cst438.listeners;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import cst438.domain.User;
import cst438.domain.UserRepository;

@RabbitListener(queues = "${queueName}")
public class W3Blistener {
	
	@Autowired
	UserRepository userRepository; 
	
	RestTemplate restTemplate;
	
	@Value("${w3aurl}")
	String w3aURL;
	
	public W3Blistener() {
		restTemplate = new RestTemplate();
	}
	
	
	@RabbitHandler
    public void receive(User u) {
        System.out.println(" [W3Blistner] Received " + u );
        try { 

	        User newuser = new User(u);
	        // write to database 
	        userRepository.save(newuser);
	        // send message back to w3a server
	        ResponseEntity<User> response = restTemplate.postForEntity(w3aURL, newuser, User.class);
	        int status = response.getStatusCodeValue();
	        System.out.println(" [W3Blistner] HttpSttaus " + status  );
	        
        } catch (Exception e) {
        	System.out.println(" [W3Blistner] Exception " + e.getMessage()  );
        }
    }
}
