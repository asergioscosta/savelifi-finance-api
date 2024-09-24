package org.savelifi.model.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orcamentos")
public class Orcamentos {

    @ManyToOne
    private Usuario usuario;

    private List<Despesas> despesas;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String nomeOrcamento;

    @Column
    @NotNull
    private float valorPlanejado;

    @Column
    @NotNull
    private float valorGasto;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column
    @NotNull
    private Date dataInicioOrcamento;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column
    @NotNull
    private Date dataFimOrcamento;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeOrcamento() {
        return nomeOrcamento;
    }

    public void setNomeOrcamento(String nomeOrcamento) {
        this.nomeOrcamento = nomeOrcamento;
    }

    public float getValorPlanejado() {
        return valorPlanejado;
    }

    public void setValorPlanejado(float valorPlanejado) {
        this.valorPlanejado = valorPlanejado;
    }

    public float getValorGasto() {
        return valorGasto;
    }

    public void setValorGasto(float valorGasto) {
        this.valorGasto = valorGasto;
    }

    public Date getDataInicioOrcamento() {
        return dataInicioOrcamento;
    }

    public void setDataInicioOrcamento(Date dataInicioOrcamento) {
        this.dataInicioOrcamento = dataInicioOrcamento;
    }

    public Date getDataFimOrcamento() {
        return dataFimOrcamento;
    }

    public void setDataFimOrcamento(Date dataFimOrcamento) {
        this.dataFimOrcamento = dataFimOrcamento;
    }

    public List<Despesas> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<Despesas> despesas) {
        this.despesas = despesas;
    }
}
