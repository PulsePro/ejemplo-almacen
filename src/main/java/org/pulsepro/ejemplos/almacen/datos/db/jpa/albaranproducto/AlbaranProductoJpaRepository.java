package org.pulsepro.ejemplos.almacen.datos.db.jpa.albaranproducto;

import org.springframework.data.repository.ListCrudRepository;

public interface AlbaranProductoJpaRepository extends ListCrudRepository<AlbaranProductoEntity, AlbaranProductoId> {
}
