package com.pandmuerto.petcitas.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity(name = "MASCOTA")
@Table(name = "MASCOTA")
public class Mascota implements Serializable {
    @Serial
    private static final long serialVersionUID = -5192311240442612550L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;

    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;

    @Basic(optional = false)
    @Column(name = "FECHA_NACIMIENTO")
    private String fechaNacimiento;

    @Basic(optional = false)
    @Column(name = "PESO")
    private Float peso;

    @Basic(optional = false)
    @Column(name = "NOTAS")
    private String notas;

    @Basic(optional = false)
    @Column(name = "SEXO")
    private String sexo;

    @Basic(optional = false)
    @Column(name = "ESPECIE")
    private String especie;

    @Basic(optional = false)
    @Column(name = "RAZA")
    private String raza;

    @ManyToOne
    @JoinColumn(name = "USR_CLIENTE")
    private Usuario cliente;
}
