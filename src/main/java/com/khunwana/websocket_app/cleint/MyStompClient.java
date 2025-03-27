package com.khunwana.websocket_app.cleint;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

public class MyStompClient {
	private StompSession session;
	private String username;
	
	public MyStompClient(String username) throws InterruptedException, ExecutionException
	{
		this.username = username;
		
		List<Transport> transport = new ArrayList<>();
		transport.add(new WebSocketTransport(new StandardWebSocketClient()));
		
		SockJsClient sockJsClient = new SockJsClient(transport);
		WebSocketStompClient stompClient = new WebSocketStompClient(sockJsClient);
		stompClient.setMessageConverter(new MappingJackson2MessageConverter());
		
		StompSessionHandler sessionHandler = new MyStompSessionHandler(username);
		String url = "ws://localhost:8080/ws";
		
		session = stompClient.connectAsync(url, sessionHandler).get();
	}
}
