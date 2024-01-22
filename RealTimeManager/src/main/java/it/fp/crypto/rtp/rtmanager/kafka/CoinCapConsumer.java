package it.fp.crypto.rtp.rtmanager.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import it.fp.crypto.rtp.rtmanager.websocket.PricesProducer;

@Component
public class CoinCapConsumer {
	
	  private static final Logger logger = LoggerFactory.getLogger(CoinCapConsumer.class);
	  
	  @Autowired
	  private PricesProducer producer;

	    @KafkaListener(topics = KafkaConstants.PRICES_TOPIC_NAME, groupId = KafkaConstants.CONSUMERS_GROUP_ID)
	    public void consume(String message){
	        logger.info(String.format("Message received -> %s", message));
	        this.producer.sendToSocket(message);
	    }

}
