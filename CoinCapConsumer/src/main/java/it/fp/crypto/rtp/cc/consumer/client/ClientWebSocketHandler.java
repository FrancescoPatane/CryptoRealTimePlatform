package it.fp.crypto.rtp.cc.consumer.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import it.fp.crypto.rtp.cc.consumer.kafka.KafkaProducer;

public class ClientWebSocketHandler extends TextWebSocketHandler {

    private static final Logger logger = LoggerFactory.getLogger(ClientWebSocketHandler.class);
    
    @Autowired
    private KafkaProducer producer;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.info("Client connection opened id {}", session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        logger.info("Client connection closed: {}", status);
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        logger.info("Client received: {}", message.getPayload());
        producer.sendMessage(message.getPayload());
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) {
        logger.info("Client transport error: {}", exception.getMessage());
    }
    
    
}
