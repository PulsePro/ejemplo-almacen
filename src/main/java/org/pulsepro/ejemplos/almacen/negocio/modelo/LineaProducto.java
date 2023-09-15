package org.pulsepro.ejemplos.almacen.negocio.modelo;

import java.util.UUID;

public record LineaProducto(UUID productoId, Integer cantidad) {
}
