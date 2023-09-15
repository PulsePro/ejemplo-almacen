package org.pulsepro.ejemplos.almacen.negocio.servicios.albaranes;

import org.pulsepro.ejemplos.almacen.datos.db.repositories.albaran.AlbaranRepository;
import org.pulsepro.ejemplos.almacen.negocio.modelo.Albaran;
import org.pulsepro.ejemplos.almacen.negocio.modelo.LineaProducto;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }
}
