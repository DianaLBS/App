package com.example.api.repo;

import com.example.api.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}