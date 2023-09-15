package org.pulsepro.ejemplos.almacen.datos.db.jpa.albaran;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.pulsepro.ejemplos.almacen.datos.db.jpa.albaranproducto.AlbaranProductoEntity;

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

    public List<AlbaranProductoEntity> getAlbaranProductoEntities() {
        return albaranProductoEntities;
    }

    public void setAlbaranProductoEntities(List<AlbaranProductoEntity> albaranProductoEntities) {
        this.albaranProductoEntities = albaranProductoEntities;
    }
}
