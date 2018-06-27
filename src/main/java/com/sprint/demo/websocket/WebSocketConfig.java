package com.sprint.demo.websocket;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

//	@Override
//	public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
//	    stompEndpointRegistry
//	         .addEndpoint("/hello") // Set websocket endpoint to connect to
//	         .setHandshakeHandler(new CustomHandshakeHandler()) // Set custom handshake handler
//	         .withSockJS(); // Add Sock JS support
//	}
	
	   @Value("${spring.activemq.user}")
	    private String mqUser;
	    @Value("${spring.activemq.password}")
	    private String mqPasword;
	    @Value("${spring.activemq.host}")
	    private String mqHost;
	    @Value("${spring.activemq.port}")
	    private int mqPort;

	    @Override
	    public void configureMessageBroker(final MessageBrokerRegistry config) {
	    	//defaults:
	    	if (mqHost == null)
	    		mqHost="9.37.138.12";
	    	if (mqPort <= 0 )
	    		mqPort = 32004;
	    	if (mqUser == null)
	    		mqUser = "admin";
	    	if (mqPasword == null)
	    		mqPasword = "admin";
	    	
	    	 config.enableSimpleBroker("/topic", "/hello" ,"/user");
	        config.enableStompBrokerRelay("/topic") //
	        .setRelayHost(mqHost) //
	        .setRelayPort(mqPort) //
	        .setClientLogin(mqUser) //
	        .setClientPasscode(mqPasword) //
	        ;
	        config.setApplicationDestinationPrefixes("/app");
	    }

//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry config) {
//        config.enableSimpleBroker("/topic");
//        config.setApplicationDestinationPrefixes("/app");
//    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/ws").withSockJS();
    }
	
}
