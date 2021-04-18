package com.jotov.telegramBot.handler;

import com.jotov.telegramBot.model.telegram.TelegramUpdate;
import com.jotov.telegramBot.model.telegram.TelegramUser;
import com.jotov.telegramBot.service.VJBillingBot;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class HelpTelegramMessageHandler implements TelegramMessageHandler {
    VJBillingBot bot;

    @Override
    public void handle(TelegramUpdate telegramUpdate) {
        if(!telegramUpdate.getMessage().getText().startsWith(bot.HELP_BUTTON)) {
            return;
        }
        Long chatId = telegramUpdate.getMessage().getChat().getId();
        String text;
        if(Objects.isNull(telegramUpdate.getMessage().getFrom().getPerson())) {
            text = "Help service is allowed only for authorized users";
        } else {
            text = "We will help you";
        }
        TelegramUser user = telegramUpdate.getMessage().getFrom();

        bot.sendTextMessage(chatId, text);

    }
}
