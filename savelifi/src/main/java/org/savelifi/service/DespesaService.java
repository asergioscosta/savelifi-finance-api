package org.savelifi.service;

import org.savelifi.model.entity.Despesa;
import org.savelifi.model.repository.DespesaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DespesaService {

    private DespesaRepository despesaRepository;

    public DespesaService(DespesaRepository despesaRepository) {
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

        if (despesa.getCategoriaDespesa() == null || despesa.getCategoriaDespesa().isEmpty()) {
            throw new Exception("Categoria de Despesa inválido. Insira um valor válido.");
        }

        if (despesa.getFormaPagamento() == null) {
            throw new Exception("Forma de Pagamento inválida. Insira um valor válido.");
        }

        if (despesa.getData() == null || despesa.getData().after(new Date())) {
            throw new Exception("Data inválida. Insira uma data válida.");
        }
        return despesaRepository.save(despesa);
    }


    public Despesa delete(Long id) throws Exception {
        Optional<Despesa> despesa = despesaRepository.findById(id);
        if (!despesa.isPresent()) {
            throw new Exception("Despesa não encontrada");
        }
        despesaRepository.delete(despesa.get());
        return despesa.get();
    }

    public Long count() {
        return despesaRepository.count();
    }

}
