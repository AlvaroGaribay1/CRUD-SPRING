package com.practica1Spring.practica1.controllers;


import com.practica1Spring.practica1.dao.UsuarioDao;
import com.practica1Spring.practica1.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuario/{id}")
    public Usuario getUsuario(@PathVariable Integer id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Alvaro");
        usuario.setApellido("Garibay");
        usuario.setEmail("prueba@prueba.com");
        usuario.setPhone("2222222222");
        usuario.setPassword("12345");

        return usuario;
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios() {
        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.DELETE)
    public void eliminarUsuario(@PathVariable int id) {
        usuarioDao.eliminarUsuario(id);
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void crearUsuario(@RequestBody Usuario usuario) {
        usuarioDao.crear(usuario);
    }
}
