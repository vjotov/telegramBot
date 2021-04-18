package com.jotov.telegramBot.transformer;

import com.jotov.telegramBot.model.telegram.TelegramChat;
import org.telegram.telegrambots.meta.api.objects.Chat;

import java.time.LocalDateTime;

public class ChatToTelegramChatTransformer implements Transformer<Chat, TelegramChat> {
    @Override
    public TelegramChat transform(Chat chat) {
        return TelegramChat.builder()
                .id(chat.getId())
                .creationDate(LocalDateTime.now())
                .channelChat(chat.isUserChat())
                .groupChat(chat.isGroupChat())
                .channelChat(chat.isChannelChat())
                .superGroupChat(chat.isSuperGroupChat())
                .build();
    }
}
