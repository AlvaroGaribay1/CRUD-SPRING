package com.practica1Spring.practica1.dao;

import com.practica1Spring.practica1.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    List<Usuario> getUsuarios ();

    void eliminarUsuario(int id);

}
