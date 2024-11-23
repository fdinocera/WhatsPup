package com.example.wpup_backend.Repository;

import com.example.wpup_backend.Entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findBySenderOrRecipient(String sender, String recipient);
}

