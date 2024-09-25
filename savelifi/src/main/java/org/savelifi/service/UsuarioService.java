package org.savelifi.service;

import org.savelifi.model.entity.Usuario;
import org.savelifi.model.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    private UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) throws Exception {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (!usuario.isPresent()) {
            throw new Exception("Orçamento não encontrado");
        }
        return usuario.get();
    }

    public Usuario save(Usuario usuario) throws Exception {
        if (usuario.getNome() == null || usuario.getNome().length() < 3) {
            throw new Exception("Nome deve ter pelo menos 3 caracteres.");
        }

        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new Exception("E-mail inválido. Digite um e-mail válido.");
        }

        Optional<Usuario> viajanteTemp = usuarioRepository.findByEmail(usuario.getEmail());
        if (viajanteTemp.isPresent()) {
            if (!Long.valueOf(usuario.getId()).equals(viajanteTemp.get().getId())) {
                throw new Exception("O email fornecido já está em uso.");
            }
        }

        if (usuario.getSobrenome() == null) {
            throw new Exception("Sobrenome inválido. Digite um sobrenome válido.");
        }

        if (usuario.getTelefone() == null) {
            throw new Exception("Telefone inválido. Digite um telefone válido.");
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario delete(Long id) throws Exception {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (!usuario.isPresent()) {
            throw new Exception("Usuário não encontrado");
        }
        usuarioRepository.delete(usuario.get());
        return usuario.get();
    }

    public Long count() {
        return usuarioRepository.count();
    }
}
