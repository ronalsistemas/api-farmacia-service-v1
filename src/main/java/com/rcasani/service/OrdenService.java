package com.rcasani.service;

import com.rcasani.domain.Orden;
import com.rcasani.repository.OrdenRepository;
import org.springframework.stereotype.Service;

@Service
public class OrdenService {

    private final OrdenRepository repository;

    public OrdenService(OrdenRepository repository) {
        this.repository = repository;
    }

    public Orden reservaOrden(Orden orden) {
        return repository.save(orden);
    }
}
