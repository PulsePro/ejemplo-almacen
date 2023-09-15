package org.pulsepro.ejemplos.almacen.negocio.servicios.albaranes;

import org.pulsepro.ejemplos.almacen.negocio.modelo.Albaran;
import org.pulsepro.ejemplos.almacen.negocio.modelo.LineaProducto;

import java.util.List;

public interface AlbaranService {
    List<Albaran> getAlbaranes();
    Albaran createAlbaran(List<LineaProducto> lineasProducto);
}
