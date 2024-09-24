package org.savelifi.service;

import org.savelifi.model.entity.Orcamentos;
import org.savelifi.model.repository.OrcamentosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrcamentosService {

    private OrcamentosRepository orcamentosRepository;

    private OrcamentosService(OrcamentosRepository orcamentosRepository) {
        this.orcamentosRepository = orcamentosRepository;
    }

    public List<Orcamentos> findAll() {
        return orcamentosRepository.findAll();
    }

    public Orcamentos delete(Long id) throws Exception {
        Optional<Orcamentos> orcamento = orcamentosRepository.findById(id);
        if (!orcamento.isPresent()) {
            throw new Exception("Orçamento não encontrado");
        }
        orcamentosRepository.delete(orcamento.get());
        return orcamento.get();
    }

    public Long count() {
        return orcamentosRepository.count();
    }

}
