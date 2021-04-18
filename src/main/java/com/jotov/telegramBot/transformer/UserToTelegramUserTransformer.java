package com.jotov.telegramBot.transformer;

import com.jotov.telegramBot.model.telegram.TelegramUser;
import org.telegram.telegrambots.meta.api.objects.User;

import java.time.LocalDateTime;

public class UserToTelegramUserTransformer implements Transformer<User, TelegramUser> {
    @Override
    public TelegramUser transform(User user) {
        return TelegramUser.builder()
                .id(user.getId())
                .creationDate(LocalDateTime.now())
                .userName(user.getUserName())
                .bot(user.getIsBot())
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .languageCode(user.getLanguageCode())
                .build();
    }
}
