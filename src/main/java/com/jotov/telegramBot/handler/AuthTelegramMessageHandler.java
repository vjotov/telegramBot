package com.jotov.telegramBot.handler;

import com.jotov.telegramBot.model.telegram.TelegramUpdate;
import com.jotov.telegramBot.model.telegram.TelegramUser;
import com.jotov.telegramBot.repository.PersonRepository;
import com.jotov.telegramBot.repository.telegram.TelegramUserRepository;
import com.jotov.telegramBot.service.VJBillingBot;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthTelegramMessageHandler implements TelegramMessageHandler {
    VJBillingBot bot;
    PersonRepository personRepository;
    TelegramUserRepository telegramUserRepository;

    @Override
    public void handle(TelegramUpdate telegramUpdate) {
        if(!telegramUpdate.getMessage().getText().startsWith("...")
         || Objects.nonNull(telegramUpdate.getMessage().getFrom()))
            return;
        String authCode = telegramUpdate.toString();
        personRepository.findByAuthCode(authCode)
                .ifPresent(person -> {
                    TelegramUser user = telegramUpdate.getMessage().getFrom();
                    user.setPerson(person);
                    telegramUserRepository.save(user);

                    Long chatId = telegramUpdate.getMessage().getChat().getId();
                    String text = "You have been authorised as";
                    bot.sendTextMessage(chatId, text);
                });
    }
}
