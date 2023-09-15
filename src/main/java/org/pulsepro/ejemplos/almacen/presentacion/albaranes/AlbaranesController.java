package org.pulsepro.ejemplos.almacen.presentacion.albaranes;

import org.pulsepro.ejemplos.almacen.negocio.modelo.LineaProducto;
import org.pulsepro.ejemplos.almacen.negocio.servicios.albaranes.AlbaranService;
import org.pulsepro.ejemplos.almacen.presentacion.comun.LineaProductoDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/albaranes")
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlbaranDto createAlbaran(@RequestBody List<CreateAlbaranRequestProduct> requestBody) {
        var lineasProducto = requestBody.stream()
                .map(lp -> new LineaProducto(lp.productoId(), lp.cantidad()))
                .toList();
        var result = this.albaranService.createAlbaran(lineasProducto);
        return new AlbaranDto(
                result.id(),
                result.lineasProducto().stream().map(LineaProductoDto::of).toList()
        );
    }
}
