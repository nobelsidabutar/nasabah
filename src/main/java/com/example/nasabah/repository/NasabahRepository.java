package com.example.nasabah.repository;

import com.example.nasabah.entity.NasabahEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NasabahRepository extends JpaRepository<NasabahEntity, Long> {
    List<NasabahEntity> findByNama (String nama);
}
