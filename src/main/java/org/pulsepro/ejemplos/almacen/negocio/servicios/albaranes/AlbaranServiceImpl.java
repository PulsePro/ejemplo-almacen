package org.pulsepro.ejemplos.almacen.negocio.servicios.albaranes;

import org.pulsepro.ejemplos.almacen.datos.db.AlbaranRepository;
import org.pulsepro.ejemplos.almacen.negocio.modelo.Albaran;
import org.pulsepro.ejemplos.almacen.negocio.modelo.LineaProducto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlbaranServiceImpl implements AlbaranService {
    private final AlbaranRepository albaranRepository;

    public AlbaranServiceImpl(AlbaranRepository albaranRepository) {
        this.albaranRepository = albaranRepository;
    }

    @Override
    public List<Albaran> getAlbaranes() {
        return this.albaranRepository.getAlbaranes();
    }

    @Override
    public Albaran createAlbaran(List<LineaProducto> lineasProducto) {
        var albaran = new Albaran(
                UUID.randomUUID(),
                lineasProducto.stream()
                        .map(lineaProducto -> new LineaProducto(lineaProducto.productoId(), lineaProducto.cantidad()))
                        .toList()
        );
        this.albaranRepository.createAlbaran(albaran);
        return albaran;
    }
}
