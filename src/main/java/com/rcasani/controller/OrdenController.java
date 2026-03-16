package com.rcasani.controller;

import com.rcasani.controller.mapper.OrdenControllerMapper;
import com.rcasani.domain.Orden;
import com.rcasani.dto.ReservaOrdenRequest;
import com.rcasani.dto.ReservaOrdenResponse;
import com.rcasani.service.OrdenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/farmacias")
public class OrdenController {

    private final OrdenService service;
    private final OrdenControllerMapper mapper;

    public OrdenController(OrdenService service, OrdenControllerMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/{farmaciaId}/ordenes/reserva")
    public ResponseEntity<ReservaOrdenResponse> reservaOrden(
            @PathVariable Long farmaciaId,
            @RequestBody ReservaOrdenRequest request) {

        ReservaOrdenRequest updatedRequest = new ReservaOrdenRequest(
                request.ordenId(),
                farmaciaId,
                request.clienteId(),
                request.items()
        );

        Orden orden = mapper.toDomain(updatedRequest);

        Orden reservarOrden = service.reservaOrden(orden);
        return ResponseEntity.ok(mapper.toResponse(reservarOrden));
    }
}
