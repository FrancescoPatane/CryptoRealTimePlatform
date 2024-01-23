package it.fp.crypto.rtp.ts.tsmanager.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PricesConsumer {
	
	  private static final Logger logger = LoggerFactory.getLogger(PricesConsumer.class);
	  

	    @KafkaListener(topics = KafkaConstants.TOPIC_NAME, groupId = KafkaConstants.GROUP_ID)
	    public void consume(String message){
	        logger.info("Message received -> {}", message);
	    }

}
