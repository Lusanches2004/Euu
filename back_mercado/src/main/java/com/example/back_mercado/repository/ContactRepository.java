package com.example.back_mercado.repository;

import com.example.back_mercado.model.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactMessage, Long> {}
