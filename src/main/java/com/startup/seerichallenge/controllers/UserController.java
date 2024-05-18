package com.startup.seerichallenge.controllers;

import com.startup.seerichallenge.models.User;
import com.startup.seerichallenge.route.Route;
import com.startup.seerichallenge.services.UserService;
import com.startup.seerichallenge.types.MediaTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Route.User.BASE)
public class UserController {
    final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = Route.User.CREATE_USER, headers = MediaTypes.Headers.ACCEPT_APPLICATION_JSON)
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        try {
            User createdUser = this.userService.create(user);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = Route.User.UPDATE_USER, headers = MediaTypes.Headers.ACCEPT_APPLICATION_JSON)
    public ResponseEntity<Object> updateUser(@RequestBody User user) {
        try {
            User updatedUser = this.userService.update(user);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = Route.User.DELETE_USER, headers = MediaTypes.Headers.ACCEPT_APPLICATION_JSON)
    public ResponseEntity<Object> deleteUser(@PathVariable Long userId) {
        try {
            Long deletedUserId = this.userService.delete(userId);
            return new ResponseEntity<>(deletedUserId, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = Route.User.GET_USER_LIST, headers = MediaTypes.Headers.ACCEPT_APPLICATION_JSON)
    public ResponseEntity<Object> getUserList() {
        try {
            List<User> user = this.userService.getUserList();
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = Route.User.SEARCH_BY_ID, headers = MediaTypes.Headers.ACCEPT_APPLICATION_JSON)
    public ResponseEntity<Object> searchById(@PathVariable Long userId) {
        try {
            Optional<User> users = this.userService.searchById(userId);
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = Route.User.SEARCH_BY_EMAIL, headers = MediaTypes.Headers.ACCEPT_APPLICATION_JSON)
    public ResponseEntity<Object> searchByEmail(@PathVariable String userEmail) {
        try {
            Optional<User> user = this.userService.searchByEmail(userEmail);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
