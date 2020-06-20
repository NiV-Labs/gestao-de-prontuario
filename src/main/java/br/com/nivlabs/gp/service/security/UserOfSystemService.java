package br.com.nivlabs.gp.service.security;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.nivlabs.gp.config.security.UserOfSystem;

/**
 * Classe UserOfSystemService.java
 * 
 * @author <a href="mailto:viniciosarodrigues@gmail.com">Vinícios Rodrigues</a>
 * 
 * @since 15 de set de 2019
 */
public class UserOfSystemService {

    private UserOfSystemService() {
    }

    public static UserOfSystem authenticated() {
        try {
            return (UserOfSystem) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            return null;
        }
    }
}