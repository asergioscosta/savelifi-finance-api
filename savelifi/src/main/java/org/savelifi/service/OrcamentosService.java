package org.savelifi.service;

import org.savelifi.model.entity.Orcamento;
import org.savelifi.model.repository.OrcamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrcamentosService {

    private OrcamentoRepository orcamentoRepository;

    private OrcamentosService(OrcamentoRepository orcamentoRepository) {
        this.orcamentoRepository = orcamentoRepository;
    }

    public List<Orcamento> findAll() {
        return orcamentoRepository.findAll();
    }

    public Orcamento findById(Long id) throws Exception {
        Optional<Orcamento> orcamento = orcamentoRepository.findById(id);
        if (!orcamento.isPresent()) {
            throw new Exception("Orçamento não encontrado");
        }
        return orcamento.get();
    }

    public Orcamento save(Orcamento orcamento) throws Exception {
        if (orcamento.getNomeOrcamento() == null || orcamento.getNomeOrcamento().length() < 3) {
            throw new Exception("Nome deve ter pelo menos 3 caracteres.");
        }

        if (orcamento.get() == null) {
            throw new Exception("Sobrenome inválido. Digite um sobrenome válido.");
        }

        if (orcamento.getSobrenome() == null) {
            throw new Exception("Sobrenome inválido. Digite um sobrenome válido.");
        }

        if (orcamento.getSobrenome() == null) {
            throw new Exception("Sobrenome inválido. Digite um sobrenome válido.");
        }

        if (orcamento.getSobrenome() == null) {
            throw new Exception("Sobrenome inválido. Digite um sobrenome válido.");
        }

        if (orcamento.getSobrenome() == null) {
            throw new Exception("Sobrenome inválido. Digite um sobrenome válido.");
        }
        return orcamentoRepository.save(orcamento);
    }

    public Orcamento delete(Long id) throws Exception {
        Optional<Orcamento> orcamento = orcamentoRepository.findById(id);
        if (!orcamento.isPresent()) {
            throw new Exception("Orçamento não encontrado");
        }
        orcamentoRepository.delete(orcamento.get());
        return orcamento.get();
    }

    public Long count() {
        return orcamentoRepository.count();
    }

}
