package org.pulsepro.ejemplos.almacen.presentacion.comun;

import org.pulsepro.ejemplos.almacen.negocio.modelo.LineaProducto;

import java.util.UUID;

public record LineaProductoDto(UUID productoId, Integer cantidad) {
    public static LineaProductoDto of(LineaProducto lineaProducto) {
        return new LineaProductoDto(lineaProducto.productoId(), lineaProducto.cantidad());
    }
}
