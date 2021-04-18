package com.jotov.telegramBot.handler;

import com.jotov.telegramBot.model.telegram.TelegramUpdate;
import com.jotov.telegramBot.model.telegram.TelegramUser;
import com.jotov.telegramBot.service.VJBillingBot;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AutoReplyTelegramMessageHandler implements TelegramMessageHandler{
    VJBillingBot bot;

    @Override
    public void handle(TelegramUpdate telegramUpdate) {
        if(telegramUpdate.getMessage().getText().startsWith(bot.START_COMMAND)
        || telegramUpdate.getMessage().getText().startsWith(bot.HELLO_BUTTON)
        || telegramUpdate.getMessage().getText().startsWith(bot.HELLO_BUTTON)){
            return;
        }
        Long chatId = telegramUpdate.getMessage().getChat().getId();
        TelegramUser user = telegramUpdate.getMessage().getFrom();
        String text = Stream.of(user.getFirstName(), user.getLastName(), "said:", telegramUpdate.getMessage().getText())
                .filter(Objects::nonNull)
                .collect(Collectors.joining( " "));
        bot.sendTextMessage(chatId, text);
    }
}
