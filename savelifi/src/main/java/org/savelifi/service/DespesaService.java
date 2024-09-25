package org.savelifi.service;

import org.savelifi.model.entity.Despesa;
import org.savelifi.model.repository.DespesaRepository;

import java.util.List;
import java.util.Optional;

public class DespesaService {

    private DespesaRepository despesaRepository;

    private DespesaService(DespesaRepository despesaRepository) {
        this.despesaRepository = despesaRepository;
    }

    public List<Despesa> findAll() {
        return despesaRepository.findAll();
    }

    public Despesa findById(Long id) throws Exception {
        Optional<Despesa> despesa = despesaRepository.findById(id);
        if (!despesa.isPresent()) {
            throw new Exception("Despesa não encontrado");
        }
        return despesa.get();
    }

    public Despesa save(Despesa despesa) throws Exception {
        if (despesa.getTipoDespesa() == null) {
            throw new Exception("Tipo de Despesa inválido. Insira um valor válido.");
        }

        if (despesa.getCategoriaDespesa() == null) {
            throw new Exception("Categoria de Despesa inválido. Insira um valor válido.");
        }

        if (despesa.getFormaPagamento() == null) {
            throw new Exception("Forma de Pagamento inválido. Insira um valor válido.");
        }

        return despesaRepository.save(despesa);
    }

    public Despesa delete(Long id) throws Exception {
        Optional<Despesa> despesa = despesaRepository.findById(id);
        if (!despesa.isPresent()) {
            throw new Exception("Orçamento não encontrado");
        }
        despesaRepository.delete(despesa.get());
        return despesa.get();
    }

    public Long count() {
        return despesaRepository.count();
    }

}