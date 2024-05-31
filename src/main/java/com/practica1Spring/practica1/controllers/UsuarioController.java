package com.practica1Spring.practica1.controllers;


import com.practica1Spring.practica1.dao.UsuarioDao;
import com.practica1Spring.practica1.models.Usuario;
import com.practica1Spring.practica1.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

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
    public List<Usuario> getUsuarios(@RequestHeader(value = "Authorization") String token) {
        if (!validarToken(token)) {
            return null;
        }

        return usuarioDao.getUsuarios();
    }

    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;

    }

    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.DELETE)
    public void eliminarUsuario(@RequestHeader(value = "Authorization") String token, @PathVariable int id) {

        if (!validarToken(token)) {
            return;
        }

        usuarioDao.eliminarUsuario(id);
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void crearUsuario(@RequestBody Usuario usuario) {
        Argon2 argon = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);
        usuarioDao.crear(usuario);
    }
}
