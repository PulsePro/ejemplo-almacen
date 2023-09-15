package org.pulsepro.ejemplos.almacen.datos.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "producto")
public class ProductoEntity {
    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    public ProductoEntity() {
    }

    public ProductoEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
