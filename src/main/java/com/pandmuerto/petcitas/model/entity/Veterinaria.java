package com.pandmuerto.petcitas.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity(name = "VETERINARIA")
@Table(name = "VETERINARIA")
public class Veterinaria implements Serializable {
    @Serial
    private static final long serialVersionUID = -5424839178463482306L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;

    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
}
