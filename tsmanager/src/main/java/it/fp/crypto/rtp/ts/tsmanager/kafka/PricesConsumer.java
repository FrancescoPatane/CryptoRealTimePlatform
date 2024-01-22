package it.fp.crypto.rtp.ts.tsmanager.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PricesConsumer {
	
	  private static final Logger logger = LoggerFactory.getLogger(PricesConsumer.class);
	  

	    @KafkaListener(topics = KafkaConstants.PRICES_TOPIC_NAME, groupId = KafkaConstants.CONSUMERS_GROUP_ID)
	    public void consume(String message){
	        logger.info(String.format("Message received -> {}", message));
	    }

}
