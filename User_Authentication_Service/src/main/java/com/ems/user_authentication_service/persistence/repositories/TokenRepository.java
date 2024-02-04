package com.ems.user_authentication_service.persistence.repositories;

import com.ems.user_authentication_service.persistence.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TokenRepository extends JpaRepository<Token, UUID> {
    Boolean existsByToken(String token);
    Optional<Token> findByToken(String token);
}
