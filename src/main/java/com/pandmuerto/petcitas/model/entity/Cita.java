package com.pandmuerto.petcitas.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity(name = "CITA")
@Table(name = "CITA")
public class Cita implements Serializable {
    @Serial
    private static final long serialVersionUID = 7579390866377893659L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;

    @Basic(optional = false)
    @Column(name = "FECHA")
    private String fecha;

    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "ID_VETERINARIA")
    private Veterinaria veterinaria;

    @ManyToOne
    @JoinColumn(name = "USR_CLIENTE")
    private Usuario cliente;

    @ManyToOne
    @JoinColumn(name = "ID_MASCOTA")
    private Mascota mascota;

}
