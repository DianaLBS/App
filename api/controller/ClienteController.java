package com.example.api.controller;

import com.example.api.model.Cliente;
import com.example.api.model.Factura;
import com.example.api.repo.ClienteRepository;
import com.example.api.repo.DetalleRepository;
import com.example.api.repo.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private DetalleRepository detalleRepository;

    @GetMapping("/{clienteId}/facturas/{facturaId}/valor")
    public ResponseEntity<Double> consultarValorFactura(
            @PathVariable Long clienteId,
            @PathVariable Long facturaId) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(clienteId);
        Optional<Factura> facturaOptional = facturaRepository.findById(facturaId);

        if (clienteOptional.isPresent() && facturaOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            Factura factura = facturaOptional.get();

            if (cliente.getFacturas().contains(factura)) {
                double valorTotal = calcularValorTotal(factura);
                if (valorTotal > 1000000 && factura.getDetalles().size() >= 5) {
                    valorTotal *= 0.9; // Aplicar descuento del 10%
                }
                return ResponseEntity.ok(valorTotal);
            }
        }

        return ResponseEntity.notFound().build();
    }

    private double calcularValorTotal(Factura factura) {
        return factura.getDetalles().stream()
                .mapToDouble(detalle -> detalle.getCantidad() * detalle.getPrecio())
                .sum();
    }
}
