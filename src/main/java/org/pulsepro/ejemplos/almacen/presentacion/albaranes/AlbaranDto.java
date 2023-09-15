package org.pulsepro.ejemplos.almacen.presentacion.albaranes;

import org.pulsepro.ejemplos.almacen.presentacion.comun.LineaProductoDto;

import java.util.List;
import java.util.UUID;

public record AlbaranDto(UUID id, List<LineaProductoDto> lineaProductos) {
}
