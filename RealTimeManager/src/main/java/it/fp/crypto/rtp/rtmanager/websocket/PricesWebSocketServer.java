package it.fp.crypto.rtp.rtmanager.websocket;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import it.fp.crypto.rtp.rtmanager.websocket.server.WebSocket;
import it.fp.crypto.rtp.rtmanager.websocket.server.handshake.ClientHandshake;
import it.fp.crypto.rtp.rtmanager.websocket.server.server.WebSocketServer;
import jakarta.annotation.PostConstruct;

@Component
public class PricesWebSocketServer extends WebSocketServer {

	private static final Logger logger = LoggerFactory.getLogger(PricesWebSocketServer.class);

	public PricesWebSocketServer() throws UnknownHostException {
		super(new InetSocketAddress(8887));
	}

    @PostConstruct
    private void postConstruct() {
        this.start();
    }

	@Override
	public void onOpen(WebSocket conn, ClientHandshake handshake) {
		logger.info("Opened websocket connection.");

	}

	@Override
	public void onClose(WebSocket conn, int code, String reason, boolean remote) {
		logger.info("Closed websocket connection.");
	}

	@Override
	public void onMessage(WebSocket conn, String message) {
		logger.info("Received: {}", message);
	}

	@Override
	public void onError(WebSocket conn, Exception ex) {
		logger.error(ex.getMessage(), ex);
	}

	@Override
	public void onStart() {
		logger.info("Start websocket connection.");
	}

}
