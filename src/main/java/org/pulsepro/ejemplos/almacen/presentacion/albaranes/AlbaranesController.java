package org.pulsepro.ejemplos.almacen.presentacion.albaranes;

import org.pulsepro.ejemplos.almacen.negocio.servicios.albaranes.AlbaranService;
import org.pulsepro.ejemplos.almacen.presentacion.comun.LineaProductoDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/albaranes")
public class AlbaranesController {
    private final AlbaranService albaranService;

    public AlbaranesController(AlbaranService albaranService) {
        this.albaranService = albaranService;
    }

    @GetMapping
    public List<AlbaranDto> getAlbaranes() {
        return this.albaranService.getAlbaranes().stream()
                .map(albaran -> new AlbaranDto(
                        albaran.id(),
                        albaran.lineasProducto().stream().map(LineaProductoDto::of).toList()
                ))
                .toList();
    }
}
