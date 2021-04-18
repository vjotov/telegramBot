package com.jotov.telegramBot.repository.telegram;

import com.jotov.telegramBot.model.telegram.TelegramMessage;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "telegram_messages", path="messages")
public interface TelegramMessageRepository extends PagingAndSortingRepository<TelegramMessage, Integer> {
}
