package org.pulsepro.ejemplos.almacen.presentacion.albaranes;

import java.util.UUID;

public record CreateAlbaranRequestProduct(UUID productoId, Integer cantidad) {
}
