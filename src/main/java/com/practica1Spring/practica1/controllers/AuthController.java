package com.practica1Spring.practica1.controllers;

import com.practica1Spring.practica1.dao.UsuarioDao;
import com.practica1Spring.practica1.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario) {

        if (usuarioDao.verificarEmailWithPassword(usuario)) {
            return "OK";
        } else {
            return "fail";
        }
    }
}
