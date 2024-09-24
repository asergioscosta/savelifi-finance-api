package org.savelifi.model.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "despesas")

public class Despesas {

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
    private String formaPagamento;

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

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public boolean isStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(boolean statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

}
