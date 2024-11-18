package com.example.senacead.cinema7.controller;

import com.example.senacead.cinema7.model.Preferencia;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerEstilo {
    
   /** @PostMapping ("/preferencias")
    public ModelAndView gravaPreferencias(@ModelAttribute Preferencia pref, HttpServletResponse response){ 
    Cookie cookiePrefEstilo = new Cookie("pref-estilo", pref.getEstilo()); 
    cookiePrefEstilo.setDomain("localhost");
    cookiePrefEstilo.setHttpOnly(true);
    cookiePrefEstilo.setMaxAge(86400);
    response.addCookie(cookiePrefEstilo); 

    return new ModelAndView("redirect:/tela-inicio"); 
}**/ 
}
