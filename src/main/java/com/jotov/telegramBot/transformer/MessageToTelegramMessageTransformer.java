package com.jotov.telegramBot.transformer;

import com.jotov.telegramBot.model.telegram.TelegramMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.time.LocalDateTime;

public class MessageToTelegramMessageTransformer implements Transformer<Message, TelegramMessage> {
    @Override
    public TelegramMessage transform(Message message) {
        return TelegramMessage.builder()
                .id(message.getMessageId())
                .creationDate(LocalDateTime.now())
                .text(message.getText())
                .build();
    }
}
