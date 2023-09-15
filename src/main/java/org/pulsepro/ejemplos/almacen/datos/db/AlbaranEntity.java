package org.pulsepro.ejemplos.almacen.datos.db;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "albaran")
public class AlbaranEntity {

    @Id
    private String id;

    @OneToMany(mappedBy = "albaran")
    private List<AlbaranProductoEntity> albaranProductoEntities = new ArrayList<>();

    public AlbaranEntity() {
    }

    public AlbaranEntity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
