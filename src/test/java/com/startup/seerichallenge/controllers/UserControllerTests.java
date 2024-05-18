package com.startup.seerichallenge.controllers;

import com.startup.seerichallenge.models.User;
import com.startup.seerichallenge.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    // UNIT TEST
    @Test
    public void getUserListTest() {
        // Arrange
        User user1 = new User();
        user1.id = 1L;
        user1.userEmail = "user1@example.com";

        User user2 = new User();
        user2.id = 2L;
        user2.userEmail = "user2@example.com";

        List<User> expectedUsers = Arrays.asList(user1, user2);

        when(userService.getUserList()).thenReturn(expectedUsers);

        ResponseEntity<Object> responseEntity = userController.getUserList();
        List<User> actualUsers = (List<User>) responseEntity.getBody();

        assertEquals(expectedUsers, actualUsers);
    }

    // FUNCTIONAL TEST
    @Test
    public void createUserTest() throws Exception {
        User user = new User();
        user.id = 1L;
        user.userEmail = "user1@example.com";

        when(userService.create(user)).thenReturn(user);

        mockMvc.perform(post("/users/create") // replace with your actual endpoint
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isCreated());
    }
}
