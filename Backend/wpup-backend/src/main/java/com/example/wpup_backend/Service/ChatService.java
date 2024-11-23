package com.example.wpup_backend.Service;

import com.example.wpup_backend.Entities.Message;
import com.example.wpup_backend.Repository.MessageRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChatService {

    private final MessageRepository messageRepository;

    public ChatService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message sendMessage(Message message) {
        return messageRepository.save(message);
    }

    public List<Message> getChatHistory(String user) {
        return messageRepository.findBySenderOrRecipient(user, user);
    }
}

