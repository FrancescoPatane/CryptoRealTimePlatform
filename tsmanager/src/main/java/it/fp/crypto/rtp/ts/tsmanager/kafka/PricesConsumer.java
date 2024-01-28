package it.fp.crypto.rtp.ts.tsmanager.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.fp.crypto.rtp.ts.tsmanager.persistence.model.Price;
import it.fp.crypto.rtp.ts.tsmanager.persistence.repository.PriceRepository;

@Service
public class PricesConsumer {
	
	  private static final Logger logger = LoggerFactory.getLogger(PricesConsumer.class);
	  
	  private static final ObjectMapper mapper = new ObjectMapper();

	  
		@Autowired
		private PriceRepository priceRepo;
	  

	    @KafkaListener(topics = KafkaConstants.TOPIC_NAME, groupId = KafkaConstants.GROUP_ID)
	    public void consume(String message){
	        logger.info("Message received -> {}", message);
	        try {
				Price p = mapper.readValue(message, Price.class);
				this.priceRepo.insert(p);
			} catch (Exception e) {
				logger.error("Error managing message {}", message);
				logger.error(e.getMessage(), e);
			}
	        
	    }

}
