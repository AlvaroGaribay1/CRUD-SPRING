package com.practica1Spring.practica1.dao;

import com.practica1Spring.practica1.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminarUsuario(int id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    @Override
    public Usuario updateUsuario (int id, Usuario updatedUsuario) {
        Usuario usuario = entityManager.find(Usuario.class, id);

        if(usuario != null) {
            usuario.setNombre(updatedUsuario.getNombre());
            usuario.setEmail(updatedUsuario.getEmail());
            usuario.setPhone(updatedUsuario.getPhone());

            entityManager.merge(usuario);
        }

        return usuario;
    }

    @Override
    public void crear(Usuario usuario) {
        entityManager.merge(usuario);
    }

    public Usuario obtenerUsuarioEmailWithPassword(Usuario usuario) {
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        if (lista.isEmpty()) {
            return null;
        }

        String passwordHashed = lista.get(0).getPassword();

        Argon2 argon = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if(argon.verify(passwordHashed, usuario.getPassword())) {
            return lista.get(0);
        }
        return null;

    }
}
