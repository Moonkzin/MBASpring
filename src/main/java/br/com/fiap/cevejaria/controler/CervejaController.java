package br.com.fiap.cevejaria.controler;

import br.com.fiap.cevejaria.dto.CervejaDTO;
import br.com.fiap.cevejaria.dto.CreateCervejaDTO;
import br.com.fiap.cevejaria.dto.Tipo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<CervejaDTO> getAll(@RequestParam(required = false) Tipo tipo){
        return cervejaDTOList.stream().filter(cervejaDTO -> tipo == null || cervejaDTO.getTipo().equals((tipo))).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public CervejaDTO findById(@PathVariable Integer id){
        return cervejaDTOList.stream()
                .filter(cervejaDTO -> cervejaDTO.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public CervejaDTO create(@RequestBody CreateCervejaDTO createCervejaDTO){
        CervejaDTO cervejaDTO = new CervejaDTO(createCervejaDTO, cervejaDTOList.size() + 1);
        cervejaDTOList.add(cervejaDTO);
        return cervejaDTO;
    }

    @PutMapping("{id}")
    public CervejaDTO update(@PathVariable Integer id, @RequestBody CreateCervejaDTO createCervejaDTO) {
        CervejaDTO cervejaDTO = findById(id);
        cervejaDTO.setMarca(createCervejaDTO.getMarca());
        cervejaDTO.setPreco(createCervejaDTO.getPreco());
        cervejaDTO.setteorAlcoolico(createCervejaDTO.getteorAlcoolico());
        cervejaDTO.setDataLancamento(createCervejaDTO.getDataLancamento());
        cervejaDTO.setTipo(createCervejaDTO.getTipo());


        return cervejaDTO;
    }
}
