package org.pulsepro.ejemplos.almacen.datos.db.jpa.producto;

import org.springframework.data.repository.ListCrudRepository;

public interface ProductoJpaRepository extends ListCrudRepository<ProductoEntity, String> {
}
