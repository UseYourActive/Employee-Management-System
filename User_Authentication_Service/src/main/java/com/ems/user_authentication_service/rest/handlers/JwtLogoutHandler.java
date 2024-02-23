package com.ems.user_authentication_service.rest.handlers;

import com.ems.user_authentication_service.persistence.entities.Token;
import com.ems.user_authentication_service.persistence.repositories.TokenRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtLogoutHandler implements LogoutHandler {
    private final TokenRepository tokenRepository;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;

        if (authHeader == null || !authHeader.startsWith("Bearer")) {
            return;
        }

        jwt = authHeader.substring(7);

        Token storedToken = tokenRepository.findByToken(jwt)
                .orElseThrow(RuntimeException::new);

        if (storedToken != null) {
            storedToken.setExpired(true);
            storedToken.setRevoked(true);
            tokenRepository.save(storedToken);
        }

        response.setStatus(HttpServletResponse.SC_OK);
    }
}
