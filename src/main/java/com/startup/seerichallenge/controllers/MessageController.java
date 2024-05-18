package com.startup.seerichallenge.controllers;

import com.startup.seerichallenge.models.Message;
import com.startup.seerichallenge.route.Route;
import com.startup.seerichallenge.services.MessageService;
import com.startup.seerichallenge.types.MediaTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Route.Message.BASE)
public class MessageController {
    final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping(value = Route.Message.CREATE_MESSAGE, headers = MediaTypes.Headers.ACCEPT_APPLICATION_JSON)
    public ResponseEntity<Object> createMessage(@RequestBody Message message) {
        try {
            Message messageCreated = this.messageService.create(message);
            return new ResponseEntity<>(messageCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = Route.Message.UPDATE_MESSAGE, headers = MediaTypes.Headers.ACCEPT_APPLICATION_JSON)
    public ResponseEntity<Object> updateMessage(@RequestBody Message message) {
        try {
            Message messageUpdated = this.messageService.update(message);
            return new ResponseEntity<>(messageUpdated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = Route.Message.DELETE_MESSAGE, headers = MediaTypes.Headers.ACCEPT_APPLICATION_JSON)
    public ResponseEntity<Object> deleteMessage(@PathVariable Long messageId) {
        try {
            Long messageIdDeleted = this.messageService.delete(messageId);
            return new ResponseEntity<>(messageIdDeleted, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = Route.Message.GET_MESSAGE_HISTORY, headers = MediaTypes.Headers.ACCEPT_APPLICATION_JSON)
    public ResponseEntity<Object> getMessageHistory() {
        try {
            List<Message> messages = this.messageService.getMessageHistory();
            return new ResponseEntity<>(messages, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = Route.Message.SEARCH_BY_ID, headers = MediaTypes.Headers.ACCEPT_APPLICATION_JSON)
    public ResponseEntity<Object> searchById(@PathVariable Long messageId) {
        try {
            Optional<Message> message = this.messageService.searchById(messageId);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = Route.Message.SEARCH_BY_CONVERSATION_ID, headers = MediaTypes.Headers.ACCEPT_APPLICATION_JSON)
    public ResponseEntity<Object> searchByConversationId(@PathVariable Long conversationId) {
        try {
            List<Message> messages = this.messageService.searchByConversationId(conversationId);
            return new ResponseEntity<>(messages, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = Route.Message.SEARCH_BY_SENDER_ID, headers = MediaTypes.Headers.ACCEPT_APPLICATION_JSON)
    public ResponseEntity<Object> searchBySenderId(@PathVariable Long senderId) {
        try {
            List<Message> messages = this.messageService.searchBySenderId(senderId);
            return new ResponseEntity<>(messages, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = Route.Message.SEARCH_BY_RECEIVER_ID, headers = MediaTypes.Headers.ACCEPT_APPLICATION_JSON)
    public ResponseEntity<Object> searchByReceiverId(@PathVariable Long receiverId) {
        try {
            List<Message> messages = this.messageService.searchByReceiverId(receiverId);
            return new ResponseEntity<>(messages, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
