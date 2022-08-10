package com.vemser.luppi.chatkafka.enums;

import java.util.Arrays;

public enum ChatEnum {
    GERAL("chat-geral"),
    GABRIEL("chat-gabriel"),
    MAICON("chat-maicon"),
    JEAN("chat-jean"),
    PAULO("chat-paulo"),
    WILLIAN("chat-willian"),
    CLEBER("chat-cleber"),
    BRUNO("chat-bruno"),
    MACHADO("chat-machado"),
    CASTRO("chat-castro"),
    RODRIGO("chat-rodrigo"),
    CESAR("chat-cesar"),
    DAYVIDSON("chat-dayvidson"),
    RAFAEL("chat-rafael");

    private String chat;

    ChatEnum(String chat) {
        this.chat = chat;
    }

    public String getChat() {
        return chat;
    }

    public static ChatEnum ofChat(String chat) {
        return Arrays.stream(ChatEnum.values())
                .filter(tp -> tp.getChat().equals(chat))
                .findFirst()
                .get();
    }
}
