package com.khunwana.websocket_app.cleint;

import java.util.ArrayList;
import java.util.List;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

public class MyStompCleint {
	private StompSession session;
	private String username;
	
	public MyStompCleint(String username)
	{
		this.username = username;
		
		List<Transport> transport = new ArrayList<>();
	}
}
