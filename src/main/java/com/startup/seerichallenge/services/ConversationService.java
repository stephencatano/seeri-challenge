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

    public Conversation create(Conversation conversation) {
        return this.conversationRepository.save(conversation);
    }

    public Conversation update(Conversation conversation) {
        return this.conversationRepository.save(conversation);
    }

    public Long delete(Long conversationId) {
        this.conversationRepository.deleteById(conversationId);
        return conversationId;
    }

    public List<Conversation> getConversationHistory() {
        return this.conversationRepository.findAll();
    }

    public Optional<Conversation> searchById(Long conversationId) {
        return this.conversationRepository.findById(conversationId);
    }

    public List<Conversation> searchByConversationType(String conversationType) {
        return this.conversationRepository.findByConversationType(conversationType);
    }
}
