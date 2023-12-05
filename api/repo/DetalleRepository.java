package com.example.api.repo;

import com.example.api.model.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleRepository extends JpaRepository<Detalle, Long> {
}