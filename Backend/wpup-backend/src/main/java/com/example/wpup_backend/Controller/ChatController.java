package com.example.wpup_backend.Controller;

import com.example.wpup_backend.Entities.Message;
import com.example.wpup_backend.Service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    // API per inviare un messaggio
    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(@RequestBody Message message) {
        Message sentMessage = chatService.sendMessage(message);
        return ResponseEntity.ok(sentMessage);
    }

    // API per recuperare la cronologia dei messaggi
    @GetMapping("/history/{user}")
    public ResponseEntity<List<Message>> getChatHistory(@PathVariable String user) {
        List<Message> messages = chatService.getChatHistory(user);
        return ResponseEntity.ok(messages);
    }
}

