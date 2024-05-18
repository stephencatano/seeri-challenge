package com.startup.seerichallenge.controllers;

import com.startup.seerichallenge.models.Conversation;
import com.startup.seerichallenge.route.Route;
import com.startup.seerichallenge.services.ConversationService;
import com.startup.seerichallenge.types.MediaTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Route.Conversation.BASE)
public class ConversationController {
    final ConversationService conversationService;

    @Autowired
    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @PostMapping(value = Route.Conversation.CREATE_CONVERSATION, headers = MediaTypes.Headers.ACCEPT_APPLICATION_JSON)
    public ResponseEntity<Object> createConversation(@RequestBody Conversation conversation) {
        try {
            Conversation conversationCreated = this.conversationService.create(conversation);
            return new ResponseEntity<>(conversationCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = Route.Conversation.UPDATE_CONVERSATION, headers = MediaTypes.Headers.ACCEPT_APPLICATION_JSON)
    public ResponseEntity<Object> updateConversation(@RequestBody Conversation conversation) {
        try {
            Conversation conversationUpdated = this.conversationService.update(conversation);
            return new ResponseEntity<>(conversationUpdated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = Route.Conversation.DELETE_CONVERSATION, headers = MediaTypes.Headers.ACCEPT_APPLICATION_JSON)
    public ResponseEntity<Object> deleteConversation(@PathVariable Long conversationId) {
        try {
            Long conversationIdDeleted = this.conversationService.delete(conversationId);
            return new ResponseEntity<>(conversationIdDeleted, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = Route.Conversation.GET_CONVERSATION_HISTORY, headers = MediaTypes.Headers.ACCEPT_APPLICATION_JSON)
    public ResponseEntity<Object> getConversationHistory() {
        try {
            List<Conversation> conversations = this.conversationService.getConversationHistory();
            return new ResponseEntity<>(conversations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = Route.Conversation.SEARCH_BY_ID, headers = MediaTypes.Headers.ACCEPT_APPLICATION_JSON)
    public ResponseEntity<Object> searchById(@PathVariable Long conversationId) {
        try {
            Optional<Conversation> conversation = this.conversationService.searchById(conversationId);
            return new ResponseEntity<>(conversation, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = Route.Conversation.SEARCH_BY_CONVERSATION_TYPE, headers = MediaTypes.Headers.ACCEPT_APPLICATION_JSON)
    public ResponseEntity<Object> searchByConversationType(@PathVariable String conversationType) {
        try {
            List<Conversation> conversations = this.conversationService.searchByConversationType(conversationType);
            return new ResponseEntity<>(conversations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
