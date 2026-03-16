package com.rcasani.dto;

import java.util.List;
import java.util.UUID;

public record ReservaOrdenRequest(
        UUID ordenId,
        Long farmaciaId,
        Long clienteId,
        List<OrdenItemRequest> items
) {
}
