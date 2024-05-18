package com.startup.seerichallenge.services;

import com.startup.seerichallenge.models.Message;
import com.startup.seerichallenge.repositories.IMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    final IMessageRepository messageRepository;

    @Autowired
    public MessageService(IMessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message create(Message message) {
        return this.messageRepository.save(message);
    }

    public Message update(Message message) {
        return this.messageRepository.save(message);
    }

    public Long delete(Long messageId) {
        this.messageRepository.deleteById(messageId);
        return messageId;
    }

    public List<Message> getMessageHistory() {
        return this.messageRepository.findAll();
    }

    public Optional<Message> searchById(Long messageId) {
        return this.messageRepository.findById(messageId);
    }

    public List<Message> searchByConversationId(Long conversationId) {
        return this.messageRepository.findByConversationId(conversationId);
    }

    public List<Message> searchBySenderId(Long senderId) {
        return this.messageRepository.findBySenderId(senderId);
    }

    public List<Message> searchByReceiverId(Long receiverId) {
        return this.messageRepository.findByReceiverId(receiverId);
    }
}
