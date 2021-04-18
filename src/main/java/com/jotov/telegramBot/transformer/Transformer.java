package com.jotov.telegramBot.transformer;

public interface Transformer<FROM, TO> {
    TO transform(FROM chat);
}
