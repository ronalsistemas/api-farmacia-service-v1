package com.rcasani.controller.mapper;

import com.rcasani.domain.Cliente;
import com.rcasani.domain.Farmacia;
import com.rcasani.domain.Orden;
import com.rcasani.domain.OrdenItem;
import com.rcasani.dto.OrdenItemResponse;
import com.rcasani.dto.ReservaOrdenRequest;
import com.rcasani.dto.ReservaOrdenResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrdenControllerMapper {

    public Orden toDomain(ReservaOrdenRequest request) {
        Farmacia farmacia = new Farmacia(request.farmaciaId(), null);
        Cliente cliente = new Cliente(request.clienteId());
        List<OrdenItem> items = request.items().stream()
                .map(i -> new OrdenItem(i.productoId(), i.productoNombre(), i.cantidad(), i.descripcion()))
                .toList();
        return new Orden(request.ordenId(), farmacia, cliente, items);
    }

    public ReservaOrdenResponse toResponse(Orden orden) {
        List<OrdenItemResponse> items = orden.getItems().stream()
                .map(i -> new OrdenItemResponse(i.getProductoId(), i.getProductoNombre(), i.getCantidad(), i.getDescripcion()))
                .toList();
        return new ReservaOrdenResponse(orden.getOrdenId(), orden.getFarmacia().getId(),
                orden.getCliente().getClienteId(), items);
    }
}
