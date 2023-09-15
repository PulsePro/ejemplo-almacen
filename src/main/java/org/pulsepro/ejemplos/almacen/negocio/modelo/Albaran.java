package org.pulsepro.ejemplos.almacen.negocio.modelo;

import java.util.List;
import java.util.UUID;

public record Albaran (UUID id, List<LineaProducto> lineasProducto) {
}
