package org.savelifi.service;

import org.savelifi.model.entity.Usuario;
import org.savelifi.model.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
            throw new Exception("Usuario não encontrado");
        }
        return usuario.get();
    }

    public Usuario save(Usuario usuario) throws Exception {
        if (usuario.getNome() == null || usuario.getNome().length() < 3) {
            throw new Exception("Nome deve ter pelo menos 3 caracteres.");
        }

        if (usuario.getSobrenome() == null) {
            throw new Exception("Sobrenome inválido. Digite um sobrenome válido.");
        }

        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new Exception("E-mail inválido. Digite um e-mail válido.");
        }

        if (!validarSenha(usuario.getSenha())) {
            throw new Exception("A senha deve ter pelo menos 8 caracteres, incluindo letras maiúsculas, minúsculas e caracteres especiais.");
        }

        Optional<Usuario> usuarioTemp = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioTemp.isPresent()) {
            if (!Long.valueOf(usuario.getId()).equals(usuarioTemp.get().getId())) {
                throw new Exception("O email fornecido já está em uso.");
            }
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

    private boolean validarSenha(String senha) {
        if (senha == null || senha.length() < 8) {
            return false;
        }

        boolean senhaLetraMaiuscula = false;
        boolean senhaLetraMinuscula = false;
        boolean senhaNumero = false;
        boolean senhaaractereEspecial = false;

        for (char c : senha.toCharArray()) {
            if (Character.isUpperCase(c)) {
                senhaLetraMaiuscula = true;
            }
            if (Character.isLowerCase(c)) {
                senhaLetraMinuscula = true;
            }
            if (Character.isDigit(c)) {
                senhaNumero = true;
            }
            if (!Character.isLetterOrDigit(c)) {
                senhaaractereEspecial = true;
            }
        }
        return senhaLetraMaiuscula && senhaLetraMinuscula && senhaNumero && senhaaractereEspecial;
    }

    public long count() {
        return usuarioRepository.count();
    }
}
