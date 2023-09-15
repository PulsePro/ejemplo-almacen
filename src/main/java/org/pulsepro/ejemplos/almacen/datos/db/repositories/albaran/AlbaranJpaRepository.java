package org.pulsepro.ejemplos.almacen.datos.db.repositories.albaran;

import org.pulsepro.ejemplos.almacen.datos.db.entities.AlbaranEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface AlbaranJpaRepository extends ListCrudRepository<AlbaranEntity, String> {
}
