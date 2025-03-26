package com.khunwana.websocket_app;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebsocketController {
	
	@Autowired
	private final SimpMessagingTemplate messagingTemplate;

	public WebsocketController(SimpMessagingTemplate messagingTemplate) {
		super();
		this.messagingTemplate = messagingTemplate;
	}
	
	@MessageMapping("/message")
	public void handleMessage(Message message)
	{
		System.out.println("Recieved message from user: "+message.getUser()+ " : "+message.getMessage());
		messagingTemplate.convertAndSend("/topic/messages",message);
		System.out.println("Sent message to /topic/messages: "+ message.getUser()+ " : "+message.getMessage());
	}
	
	
}
