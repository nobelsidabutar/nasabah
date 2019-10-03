package com.example.nasabah.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class NasabahDto {
    private long nik;
    private String nama;
    private double pendapatan;
    private Date tanggalLahir;
    private String career;

    public  NasabahDto(Long nik, String nama, double pendapatan, Date tanggalLahir, String career){
        this.nik = nik;
        this.nama = nama;
        this.pendapatan = pendapatan;
        this.tanggalLahir = tanggalLahir;
        this.career = career;
    }
}
