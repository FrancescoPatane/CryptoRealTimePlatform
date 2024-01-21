package it.fp.crypto.rtp.cc.consumer.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
        LOGGER.info(String.format("Sending message -> %s", message));
//        message = "{ \"value1\": 1.0, \"value2\": 2, \"value3\": 3.33 }";
        kafkaTemplate.send(KafkaConstants.TOPIC_NAME, message);
        LOGGER.info(String.format("Message sent -> %s", message));
    }

}
