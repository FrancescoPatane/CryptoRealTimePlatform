package it.fp.crypto.rtp.rtmanager.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CoinCapConsumer {
	
	  private static final Logger LOGGER = LoggerFactory.getLogger(CoinCapConsumer.class);

	    @KafkaListener(topics = KafkaConstants.TOPIC_NAME, groupId = KafkaConstants.GROUP_ID)
	    public void consume(String message){
	        LOGGER.info(String.format("Message received -> %s", message));
	    }

}
