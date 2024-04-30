package com.practica1Spring.practica1.controllers;


import com.practica1Spring.practica1.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @RequestMapping(value = "usuario/{id}")
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

    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuariosAll() {
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setNombre("Eduardo");
        usuario.setApellido("Cortes");
        usuario.setEmail("eduardo@test.com");
        usuario.setPhone("22222222222");
        usuario.setPassword("saaaaaaaaa");

        Usuario usuario2 = new Usuario();
        usuario2.setId(2);
        usuario2.setNombre("Alberto");
        usuario2.setApellido("Gonzales");
        usuario2.setEmail("alberto@test.com");
        usuario2.setPhone("222222222");
        usuario2.setPassword("aaaaawssss");

        Usuario usuario3 = new Usuario();
        usuario3.setId(3);
        usuario3.setNombre("Isaac");
        usuario3.setApellido("Hernandez");
        usuario3.setEmail("isaac@test.com");
        usuario3.setPhone("222222222");
        usuario3.setPassword("222222222");


        usuarios.add(usuario);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
    return usuarios;
    }


}
