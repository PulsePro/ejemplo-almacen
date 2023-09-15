package org.pulsepro.ejemplos.almacen.datos.db.jpa.albaranproducto;

import jakarta.persistence.*;
import org.pulsepro.ejemplos.almacen.datos.db.jpa.albaran.AlbaranEntity;
import org.pulsepro.ejemplos.almacen.datos.db.jpa.producto.ProductoEntity;

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

    public AlbaranProductoEntity(AlbaranProductoId id, AlbaranEntity albaran, ProductoEntity producto, Integer cantidad) {
        this.id = id;
        this.albaran = albaran;
        this.producto = producto;
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
