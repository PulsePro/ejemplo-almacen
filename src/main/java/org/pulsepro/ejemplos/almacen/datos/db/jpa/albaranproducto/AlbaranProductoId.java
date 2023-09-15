package org.pulsepro.ejemplos.almacen.datos.db.jpa.albaranproducto;

import jakarta.persistence.Embeddable;

@Embeddable
public class AlbaranProductoId {
    private String albaranId;
    private String productoId;

    public AlbaranProductoId() {
    }

    public AlbaranProductoId(String albaranId, String productoId) {
        this.albaranId = albaranId;
        this.productoId = productoId;
    }

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
