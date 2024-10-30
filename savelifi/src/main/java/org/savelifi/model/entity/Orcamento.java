package org.savelifi.model.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orcamento")
public class Orcamento {

    @Transient
    private String conteudoOrcamento;
    @Transient
    private Impressao impressao;

    @ManyToOne
    private Usuario usuario;

    @OneToMany
    private List<Despesa> despesa;

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

    public Orcamento(String tipoImpressao) {
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName("model.entity.Orcamento" + tipoImpressao);
            objeto = classe.newInstance();
        } catch (Exception ex) {
            this.impressao = null;
        }
        if (!(objeto instanceof Impressao)) {
            this.impressao = null;
        }
        this.impressao = (Impressao) objeto;
    }

    public Orcamento() {

    }

    private String getConteudoOrcamento() {
        return conteudoOrcamento;
    }

    public void setConteudoOrcamento(String conteudoOrcamento) {
        this.conteudoOrcamento = conteudoOrcamento;
    }

    public void imprimir() {
        this.impressao.imprimir(conteudoOrcamento);
    }

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

    public List<Despesa> getDespesa() {
        return despesa;
    }

    public void setDespesa(List<Despesa> despesa) {
        this.despesa = despesa;
    }


}
