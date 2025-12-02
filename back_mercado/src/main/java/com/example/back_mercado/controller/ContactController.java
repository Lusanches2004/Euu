package com.example.back_mercado.controller;

import com.example.back_mercado.dto.ContactRequest;
import com.example.back_mercado.model.ContactMessage;
import com.example.back_mercado.repository.ContactRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://localhost:5174/")
public class ContactController {

    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @PostMapping
    public ResponseEntity<ContactMessage> submit(@Valid @RequestBody ContactRequest contactRequest) {

        ContactMessage contact = new ContactMessage();
        contact.setName(contactRequest.getName());
        contact.setEmail(contactRequest.getEmail());
        contact.setTelefone(contactRequest.getTelefone());
        contact.setAssunto(contactRequest.getAssunto());
        contact.setMessage(contactRequest.getMessage());

        ContactMessage saved = contactRepository.save(contact);

        return ResponseEntity
                .created(URI.create("/api/contact/" + saved.getId()))
                .body(saved);
    }

    @GetMapping
    public ResponseEntity<List<ContactMessage>> getAll() {
        List<ContactMessage> list = contactRepository.findAll();
        return ResponseEntity.ok(list);
    }
}
