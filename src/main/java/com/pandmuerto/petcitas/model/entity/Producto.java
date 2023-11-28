package com.pandmuerto.petcitas.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity(name = "PRODUCTO")
@Table(name = "PRODUCTO")
public class Producto implements Serializable {

    @Serial
    private static final long serialVersionUID = 4520178648833189334L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Basic(optional = false)
    private int id;

    @Column(name = "NOMBRE")
    @Basic(optional = false)
    private String nombre;

    @Column(name = "DESCRIPCION")
    @Basic(optional = false)
    private String descripcion;

    @Column(name = "PRECIO")
    @Basic(optional = false)
    private Float precio;

    @ManyToOne
    @JoinColumn(name = "ID_VETERINARIA")
    private Veterinaria veterinaria;
}
