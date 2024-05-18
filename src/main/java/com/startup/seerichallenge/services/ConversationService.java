package com.startup.seerichallenge.services;

import com.startup.seerichallenge.models.Conversation;
import com.startup.seerichallenge.repositories.IConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConversationService {
    final IConversationRepository conversationRepository;

    @Autowired
    public ConversationService(IConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    public void create(Conversation conversation) {
        this.conversationRepository.save(conversation);
    }

    public void update(Conversation conversation) {
        this.conversationRepository.save(conversation);
    }

    public void delete(Long conversationId) {
        this.conversationRepository.deleteById(conversationId);
    }

    public List<Conversation> getConversationHistory() {
        return this.conversationRepository.findAll();
    }

    public Optional<Conversation> searchById(Long conversationId) {
        return this.conversationRepository.findById(conversationId);
    }

    List<Conversation> searchByEmail(String conversationType) {
        return this.conversationRepository.findByConversationType(conversationType);
    }
}
