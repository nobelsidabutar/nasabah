package com.example.nasabah.entity;


import groovy.transform.KnownImmutable;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "nasabah")
public class NasabahEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="nik")
    private long nik;

    @Column(name = "nama", length = 250 , nullable = false)
    @NotNull
    private String nama;

    @Column(name = "pendapatan", nullable = false)
    @NotNull
    private Double pendapatan;

    @Temporal(TemporalType.DATE)
    @Column(name = "tanggal_lahir", nullable = false)
    @NotNull
    private Date tanggalLahir;

    @Column(name = "career", length = 250 , nullable = false)
    @NotNull
    private String career;
}
