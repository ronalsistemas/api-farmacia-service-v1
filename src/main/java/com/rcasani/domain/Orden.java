package com.rcasani.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orden {
    private UUID ordenId;
    private Farmacia farmacia;
    private Cliente cliente;
    private List<OrdenItem> items;
}
