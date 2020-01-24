package br.com.fiap.cevejaria.dto;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class CervejaDTO {

    public CervejaDTO(){}

    private Integer id;
    private String marca;
    private Double teorAucoolico;
    private Tipo tipo;
    private BigDecimal preco;
    private ZonedDateTime dataLancamento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public CervejaDTO(Integer id, String marca, Double teorAucoolico, Tipo tipo, BigDecimal preco, ZonedDateTime dataLancamento) {
        this.id = id;
        this.marca = marca;
        this.teorAucoolico = teorAucoolico;
        this.tipo = tipo;
        this.preco = preco;
        this.dataLancamento = dataLancamento;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getTeorAucoolico() {
        return teorAucoolico;
    }

    public void setTeorAucoolico(Double teorAucoolico) {
        this.teorAucoolico = teorAucoolico;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public ZonedDateTime getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(ZonedDateTime dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}
