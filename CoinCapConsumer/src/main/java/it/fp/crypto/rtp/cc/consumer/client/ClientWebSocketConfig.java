package it.fp.crypto.rtp.cc.consumer.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

@Configuration
public class ClientWebSocketConfig {

    @Bean
    public WebSocketConnectionManager webSocketConnectionManager() {
        WebSocketConnectionManager manager = new WebSocketConnectionManager(
                webSocketClient(),
                webSocketHandler(),
                "wss://ws.coincap.io/prices?assets=bitcoin,ethereum,binance-coin,bitcoin-cash,litecoin"
        );
        manager.setAutoStartup(true);
        return manager;
    }

    @Bean
    public WebSocketClient webSocketClient() {
        return new StandardWebSocketClient();
    }

    @Bean
    public WebSocketHandler webSocketHandler() {
        return new ClientWebSocketHandler();
    }
}
