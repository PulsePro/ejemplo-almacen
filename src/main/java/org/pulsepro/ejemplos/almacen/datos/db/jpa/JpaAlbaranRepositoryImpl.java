package org.pulsepro.ejemplos.almacen.datos.db.jpa;

import jakarta.transaction.Transactional;
import org.pulsepro.ejemplos.almacen.datos.db.AlbaranRepository;
import org.pulsepro.ejemplos.almacen.datos.db.jpa.albaran.AlbaranEntity;
import org.pulsepro.ejemplos.almacen.datos.db.jpa.albaran.AlbaranJpaRepository;
import org.pulsepro.ejemplos.almacen.datos.db.jpa.albaranproducto.AlbaranProductoEntity;
import org.pulsepro.ejemplos.almacen.datos.db.jpa.albaranproducto.AlbaranProductoId;
import org.pulsepro.ejemplos.almacen.datos.db.jpa.albaranproducto.AlbaranProductoJpaRepository;
import org.pulsepro.ejemplos.almacen.datos.db.jpa.producto.ProductoEntity;
import org.pulsepro.ejemplos.almacen.datos.db.jpa.producto.ProductoJpaRepository;
import org.pulsepro.ejemplos.almacen.negocio.modelo.Albaran;
import org.pulsepro.ejemplos.almacen.negocio.modelo.LineaProducto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class JpaAlbaranRepositoryImpl implements AlbaranRepository {
    private final AlbaranJpaRepository albaranJpaRepository;
    private final AlbaranProductoJpaRepository albaranProductoJpaRepository;
    private final ProductoJpaRepository productoJpaRepository;

    public JpaAlbaranRepositoryImpl(
            AlbaranJpaRepository albaranJpaRepository,
            AlbaranProductoJpaRepository albaranProductoJpaRepository,
            ProductoJpaRepository productoJpaRepository) {
        this.albaranJpaRepository = albaranJpaRepository;
        this.albaranProductoJpaRepository = albaranProductoJpaRepository;
        this.productoJpaRepository = productoJpaRepository;
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

    @Transactional
    public void createAlbaran(Albaran albaran) {
        var albaranEntity = new AlbaranEntity(albaran.id().toString());

        // Creamos un hashmap de productos que podemos usar despues para insertarlos en la db de forma consistente.
        var productoEntities = this.productoJpaRepository.findAllById(
                albaran.lineasProducto().stream()
                    .map(LineaProducto::productoId)
                    .map(UUID::toString)
                    .toList()
        ).stream().collect(Collectors.toMap(ProductoEntity::getId, Function.identity()));

        var albaranProductoEntities = albaran.lineasProducto().stream()
                .map(lineaProducto -> new AlbaranProductoEntity(
                        new AlbaranProductoId(
                                albaran.id().toString(),
                                lineaProducto.productoId().toString()
                        ),
                        albaranEntity,
                        productoEntities.get(lineaProducto.productoId().toString()),
                        lineaProducto.cantidad()
                ))
                .toList();

        this.albaranJpaRepository.save(albaranEntity);
        this.albaranProductoJpaRepository.saveAll(albaranProductoEntities);
    }
}
