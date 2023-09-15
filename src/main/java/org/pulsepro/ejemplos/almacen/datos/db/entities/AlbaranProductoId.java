package org.pulsepro.ejemplos.almacen.datos.db.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class AlbaranProductoId {
    private String albaranId;
    private String productoId;

    public String getAlbaranId() {
        return albaranId;
    }

    public void setAlbaranId(String albaranId) {
        this.albaranId = albaranId;
    }

    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }
}
