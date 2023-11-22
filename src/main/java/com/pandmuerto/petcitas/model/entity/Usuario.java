package com.pandmuerto.petcitas.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity(name = "USUARIO")
@Table(name = "USUARIO")
public class Usuario implements Serializable {
    @Serial
    private static final long serialVersionUID = 2082751637509541325L;

    @Id
    @Column(name = "USERNAME")
    @Basic(optional = false)
    private String username;

    @Column(name = "PASSWORD")
    @Basic(optional = false)
    private String password;

    @Column(name = "EMAIL")
    @Basic(optional = false)
    private String email;

    @Column(name = "NOMBRE")
    @Basic(optional = false)
    private String nombre;

    @Column(name = "APELLIDO")
    @Basic(optional = false)
    private String apellido;

    @Column(name = "TELEFONO")
    @Basic(optional = false)
    private String telefono;

    @Column(name = "ROL")
    @Basic(optional = false)
    private String rol;

    @ManyToOne
    @JoinColumn(name = "ID_VETERINARIA")
    private Veterinaria veterinaria;
}
