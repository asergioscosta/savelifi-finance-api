package org.savelifi.model.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.savelifi.service.FormaPagamento;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "despesa")

public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data;

    @Column
    @NotNull
    private String tipoDespesa;

    @Column
    @NotNull
    private String categoriaDespesa;

    @Column
    @NotNull
    private FormaPagamento formaPagamento;

    @Column
    @NotNull
    private boolean statusPagamento;

    @Column
    @ManyToOne
    private Usuario usuario;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(String tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public String getCategoriaDespesa() {
        return categoriaDespesa;
    }

    public void setCategoriaDespesa(String categoriaDespesa) {
        this.categoriaDespesa = categoriaDespesa;
    }

    public boolean isStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(boolean statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
