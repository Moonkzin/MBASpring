package br.com.fiap.cevejaria.controler;

import br.com.fiap.cevejaria.dto.CervejaDTO;
import br.com.fiap.cevejaria.dto.Tipo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("Cervejas")
public class CervejaController {

    private List<CervejaDTO> cervejaDTOList = new ArrayList<>();

    public CervejaController(){

        cervejaDTOList.add(new CervejaDTO(1, "marca 1", 14.5, Tipo.PILSEN, BigDecimal.valueOf(11.9), ZonedDateTime.now().minusYears(1)));
        cervejaDTOList.add(new CervejaDTO(2, "marca 2", 24.5, Tipo.ALE, BigDecimal.valueOf(12.9), ZonedDateTime.now().minusYears(2)));
        cervejaDTOList.add(new CervejaDTO(3, "marca 3", 34.5, Tipo.STOUT, BigDecimal.valueOf(13.9), ZonedDateTime.now().minusYears(3)));
        cervejaDTOList.add(new CervejaDTO(4, "marca 4", 44.5, Tipo.WEISS, BigDecimal.valueOf(14.9), ZonedDateTime.now().minusYears(4)));
    }

    @GetMapping
    public List<CervejaDTO> getAll(){
        return cervejaDTOList ;
    }
}
