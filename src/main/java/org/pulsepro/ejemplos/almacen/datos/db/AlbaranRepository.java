package org.pulsepro.ejemplos.almacen.datos.db;

import org.pulsepro.ejemplos.almacen.negocio.modelo.Albaran;

import java.util.List;

public interface AlbaranRepository {
    List<Albaran> getAlbaranes();
    void createAlbaran(Albaran albaran);
}
