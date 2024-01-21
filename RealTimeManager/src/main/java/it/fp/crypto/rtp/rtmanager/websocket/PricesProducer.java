package it.fp.crypto.rtp.rtmanager.websocket;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class PricesProducer {
	
	  private static final Logger logger = LoggerFactory.getLogger(PricesProducer.class);
	  
	  public static final ObjectMapper mapper = new ObjectMapper();
	  
		private SimpMessagingTemplate template;

		@Autowired
		public PricesProducer(SimpMessagingTemplate template) {
			this.template = template;
		}

	    public void sendToSocket(String message){
	        logger.info(String.format("Message received -> %s", message));

	    	try {
				Map<String, String> jsonMessageIn = mapper.readValue(message, new TypeReference<Map<String, String>>(){});
				Map<String, Object> jsonMessageOut = new HashMap<>(jsonMessageIn.size()+1);
				jsonMessageOut.put("time", new Date());
				jsonMessageIn.forEach((k,v) -> jsonMessageOut.put(k, new BigDecimal(v)));
				String out = mapper.writeValueAsString(jsonMessageOut);
		        GenericMessage<byte[]> messageOut = new GenericMessage<>(out.getBytes());
		        logger.info(String.format("Message prepared and sent to ws -> %s", out));
			    template.send("/prices/rt", messageOut);
	    	} catch (JsonProcessingException e) {
				logger.error("Could not read message {}", message);
				logger.error(e.getMessage(), e);
			}
	       

	    }

}
