package it.fp.crypto.rtp.rtmanager.kafka;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.fp.crypto.rtp.rtmanager.dto.PriceTsDto;
import it.fp.crypto.rtp.rtmanager.websocket.PricesWebSocketServer;


@Component
public class TsProducer {

	private static final Logger logger = LoggerFactory.getLogger(TsProducer.class);

	public static final ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

	  @Autowired
	  private PricesWebSocketServer socketServer;

	public void convertPricesDataAndSend(String message) {
		try {
			Map<String, String> jsonMessage = mapper.readValue(message, new TypeReference<Map<String, String>>(){});
			Date now = new Date();
			jsonMessage.forEach((k, v) -> this.sendPriceTs(new PriceTsDto(now, new BigDecimal(v), k)));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	private void sendPriceTs(PriceTsDto dto) {
		logger.info("Sending message - {}", dto.toString());
        try {
        	String json = mapper.writeValueAsString(dto);
	        this.socketServer.broadcast(json);
			kafkaTemplate.send(KafkaConstants.PRICES_TS_TOPIC_NAME, json);
		} catch (JsonProcessingException e) {
			logger.error(e.getMessage(), e);
		}
        logger.info("Message sent - {}", dto.toString());
	}


}
