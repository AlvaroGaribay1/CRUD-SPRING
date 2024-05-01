package com.practica1Spring.practica1.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "usuarios")
@ToString @EqualsAndHashCode
public class Usuario {

    //Setters y Getters añadidos por la dependencia de Lombok
    //Column para asignar el campo de la tabla en cuestión

    @Getter @Setter @Column(name = "id")
    //Asignamos la clave primaria o identificador
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Getter @Setter  @Column(name = "apellido")
    private String apellido;

    @Getter @Setter @Column(name = "email")
    private String email;

    @Getter @Setter @Column(name = "telefono")
    private String phone;

    @Getter @Setter @Column(name = "password")
    private String password;


}
