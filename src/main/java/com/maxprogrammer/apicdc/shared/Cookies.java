package com.maxprogrammer.apicdc.shared;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maxprogrammer.apicdc.site.models.Carrinho;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Component
public class Cookies {

    /**
     * @param key      chave que vai ser gerada para o cookie
     * @param carrinho carrinho de compras que vai ser serializado
     * @param response
     */
    public void writeAsJson(String key, Carrinho carrinho, HttpServletResponse response) {
        try {
            Cookie cookie = new Cookie(key, new ObjectMapper().writeValueAsString(carrinho));
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}