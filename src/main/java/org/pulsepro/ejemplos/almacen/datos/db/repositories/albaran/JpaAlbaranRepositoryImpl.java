package org.pulsepro.ejemplos.almacen.datos.db.repositories.albaran;

import org.pulsepro.ejemplos.almacen.negocio.modelo.Albaran;
import org.pulsepro.ejemplos.almacen.negocio.modelo.LineaProducto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class JpaAlbaranRepositoryImpl implements AlbaranRepository {
    private final AlbaranJpaRepository albaranJpaRepository;

    public JpaAlbaranRepositoryImpl(AlbaranJpaRepository albaranJpaRepository) {
        this.albaranJpaRepository = albaranJpaRepository;
    }

    public List<Albaran> getAlbaranes() {
        return this.albaranJpaRepository.findAll().stream()
                .map(albaranEntity -> new Albaran(
                        UUID.fromString(albaranEntity.getId()),
                        albaranEntity.getAlbaranProductoEntities().stream()
                                .map(albaranProductoEntity -> new LineaProducto(
                                        UUID.fromString(albaranProductoEntity.getId().getProductoId()),
                                        albaranProductoEntity.getCantidad()
                                ))
                                .toList()
                ))
                .toList();
    }
}
