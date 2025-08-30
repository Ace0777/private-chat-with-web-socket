package br.com.ace.chat.entity;

import lombok.*;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {

    String from;
    String to;
    String content;

    public ChatMessage(String content) {
    }
}
