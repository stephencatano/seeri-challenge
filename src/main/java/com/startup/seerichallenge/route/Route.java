package com.startup.seerichallenge.route;

public final class Route {

    private Route() {}

    public static final class User {
        private User() {}

        public static final String BASE = "/users";
        public static final String CREATE_USER = "/create";
        public static final String UPDATE_USER = "/update";
        public static final String DELETE_USER = "/delete";
        public static final String GET_USER_LIST = "/list";
        public static final String SEARCH_BY_ID = "/search/user/{userId}";
        public static final String SEARCH_BY_EMAIL = "/search/email/{userEmail}";
    }

    public static final class Conversation {
        private Conversation() {}

        public static final String BASE = "/conversation";
        public static final String CREATE_CONVERSATION = "/create";
        public static final String UPDATE_CONVERSATION = "/update";
        public static final String DELETE_CONVERSATION = "/delete";
        public static final String GET_CONVERSATION_HISTORY = "/history";
        public static final String SEARCH_BY_ID = "/search/{conversationId}";
        public static final String SEARCH_BY_CONVERSATION_TYPE = "/search/type/{conversationType}";
    }

    public static final class Message {
        private Message() {}

        public static final String BASE = "/message";
        public static final String CREATE_MESSAGE = "/create";
        public static final String UPDATE_MESSAGE = "/update";
        public static final String DELETE_MESSAGE = "/delete";
        public static final String GET_MESSAGE_HISTORY = "/history";
        public static final String SEARCH_BY_ID = "/search/{messageId}";
        public static final String SEARCH_BY_CONVERSATION_ID = "/search/conversation/{conversationId}";
        public static final String SEARCH_BY_SENDER_ID = "/search/sender/{senderId}";
        public static final String SEARCH_BY_RECEIVER_ID = "/search/receiver/{receiverId}";
    }
}