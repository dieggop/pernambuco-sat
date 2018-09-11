package com.br.carrilho.silva.pernambucosat.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.xml.ws.Response;
@Controller
@Transactional
@RequestMapping("/")
public class HomeController {



    @RequestMapping(method = RequestMethod.GET)
    public String home() {

        return "index";
    }
/*
    @RequestMapping(path = "/nova", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> nova() {

        return new ResponseEntity<>(HttpStatus.OK);
    }
*/

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {

        return "login";
    }
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin() {

        return "admin";
    }
  @RequestMapping(value = "/access-denied", method = RequestMethod.GET)
    public String accessDenied() {

        return "access-denied";
    }


}
