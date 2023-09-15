package org.pulsepro.ejemplos.almacen.datos.db;

import jakarta.persistence.Embeddable;

@Embeddable
public class AlbaranProductoId {
    private String albaranId;
    private String productoId;
}
