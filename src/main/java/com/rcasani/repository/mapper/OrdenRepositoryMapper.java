package com.rcasani.repository.mapper;

import com.rcasani.domain.Cliente;
import com.rcasani.domain.Farmacia;
import com.rcasani.domain.Orden;
import com.rcasani.domain.OrdenItem;
import com.rcasani.infraestructure.entity.FarmaciaEntity;
import com.rcasani.infraestructure.entity.OrdenEntity;
import com.rcasani.infraestructure.entity.OrdenItemEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrdenRepositoryMapper {

    public OrdenEntity toEntity(Orden orden) {
        OrdenEntity entity = new OrdenEntity();
        entity.setId(orden.getOrdenId());
        entity.setFarmacia(new FarmaciaEntity());
        entity.getFarmacia().setId(orden.getFarmacia().getId());
        entity.setClienteId(orden.getCliente().getClienteId());

        List<OrdenItemEntity> itemEntities = orden.getItems().stream().map(i -> {
            OrdenItemEntity e = new OrdenItemEntity();
            e.setProductoId(i.getProductoId());
            e.setProductoNombre(i.getProductoNombre());
            e.setCantidad(i.getCantidad());
            e.setDescripcion(i.getDescripcion());
            e.setOrden(entity);
            return e;
        }).toList();

        entity.setItems(itemEntities);
        return entity;
    }

    public Orden toDomain(OrdenEntity entity) {
        Farmacia farmacia = new Farmacia(entity.getFarmacia().getId(), entity.getFarmacia().getNombre());
        Cliente cliente = new Cliente(entity.getClienteId());

        List<OrdenItem> items = entity.getItems().stream()
                .map(e -> new OrdenItem(e.getProductoId(), e.getProductoNombre(), e.getCantidad(), e.getDescripcion()))
                .toList();

        return new Orden(entity.getId(), farmacia, cliente, items);
    }
}
