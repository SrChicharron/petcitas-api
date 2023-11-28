package com.pandmuerto.petcitas.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity(name = "HISTORIAL")
@Table(name = "HISTORIAL")
public class Historial implements Serializable {
    @Serial
    private static final long serialVersionUID = -6929472058182667070L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;

    @Basic(optional = false)
    @Column(name = "FECHA")
    private String fecha;

    @Basic(optional = false)
    @Column(name = "MALESTAR")
    private String malestar;

    @Basic(optional = false)
    @Column(name = "TRATAMIENTO")
    private String tratamiento;

    @ManyToOne
    @JoinColumn(name = "USR_CLIENTE")
    private Usuario cliente;

    @ManyToOne
    @JoinColumn(name = "ID_MASCOTA")
    private Mascota mascota;
}
