package com.startup.seerichallenge.repositories;

import com.startup.seerichallenge.models.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IConversationRepository extends JpaRepository<Conversation, Long> {
    List<Conversation> findByConversationType(String conversationType);
}
