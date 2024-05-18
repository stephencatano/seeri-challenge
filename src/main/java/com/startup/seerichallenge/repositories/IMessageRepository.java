package com.startup.seerichallenge.repositories;

import com.startup.seerichallenge.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByConversationId(Long conversationId);
    List<Message> findBySenderId(Long senderId);
    List<Message> findByReceiverId(Long receiverId);
}
