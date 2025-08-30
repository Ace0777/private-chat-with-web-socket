package br.com.ace.chat.controller;

import br.com.ace.chat.entity.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;

    public ChatController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/private-message")
    public void chatMessage(ChatMessage message) {
        System.out.println("Mensagem recebida: " + message.getFrom()
                + " → " + message.getTo() + ": " + message.getContent());

        messagingTemplate.convertAndSend(
                "/topic/" + message.getTo(),
                message
        );
    }



}
