package com.jotov.telegramBot.transformer;

import com.jotov.telegramBot.model.telegram.TelegramUpdate;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.time.LocalDateTime;

public class UpdateToTelegramUpdateTransformer implements Transformer<Update, TelegramUpdate> {
    @Override
    public TelegramUpdate transform(Update update) {
        return TelegramUpdate.builder()
                .id(update.getUpdateId())
                .creationDate(LocalDateTime.now())
                .build();
    }
}
