package com.jotov.telegramBot.repository.telegram;

import com.jotov.telegramBot.model.telegram.TelegramChat;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "telegram_chats", path = "chats")
interface TelegramChatRepository  extends PagingAndSortingRepository<TelegramChatRepository, Long> {
    Optional<TelegramChat> findByUser_Id(Integer userId);
    Optional<TelegramChat> findByUser_Person_Id(Integer personId);
}
