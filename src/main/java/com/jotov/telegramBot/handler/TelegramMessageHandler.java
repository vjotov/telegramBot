package com.jotov.telegramBot.handler;

import com.jotov.telegramBot.model.telegram.TelegramUpdate;

interface TelegramMessageHandler {
    void handle(TelegramUpdate telegramUpdate);
}
