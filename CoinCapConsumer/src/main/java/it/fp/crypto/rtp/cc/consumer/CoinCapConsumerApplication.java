package it.fp.crypto.rtp.cc.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.client.WebSocketClient;

@SpringBootApplication
public class CoinCapConsumerApplication {
	
	@Autowired
	WebSocketClient client;

	public static void main(String[] args) {
		SpringApplication.run(CoinCapConsumerApplication.class, args);
	}

}
