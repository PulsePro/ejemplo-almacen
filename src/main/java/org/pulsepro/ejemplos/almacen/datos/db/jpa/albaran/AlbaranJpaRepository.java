package org.pulsepro.ejemplos.almacen.datos.db.jpa.albaran;

import org.pulsepro.ejemplos.almacen.datos.db.jpa.albaran.AlbaranEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface AlbaranJpaRepository extends ListCrudRepository<AlbaranEntity, String> {
}
