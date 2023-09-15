package org.pulsepro.ejemplos.almacen.datos.db;

import jakarta.persistence.*;

@Entity(name = "albaran_producto")
public class AlbaranProductoEntity {

    @EmbeddedId
    private AlbaranProductoId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("albaranId")
    private AlbaranEntity albaran;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productoId")
    private ProductoEntity producto;

    @Column(nullable = false)
    private Integer cantidad = 1;

    public AlbaranProductoEntity() {
    }

    public AlbaranProductoEntity(AlbaranProductoId id, Integer cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public AlbaranProductoId getId() {
        return id;
    }

    public void setId(AlbaranProductoId id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
