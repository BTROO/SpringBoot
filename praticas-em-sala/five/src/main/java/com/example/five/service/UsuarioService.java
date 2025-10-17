package com.example.five.service;

import com.example.five.dto.UsuarioRequestDTO;
import com.example.five.dto.UsuarioResponseDTO;
import com.example.five.model.UsuarioModel;
import com.example.five.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    //Salvar um novo usuário. -------------------------------------------
    public UsuarioModel salvarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        //verificando se os dados do novo usuario ja existem no banco de dados.
        if (usuarioRepository.findByEmail(usuarioRequestDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email já cadastrado");
        }

        UsuarioModel novoUsuario = new UsuarioModel();
        novoUsuario.setNome(usuarioRequestDTO.getNome());
        novoUsuario.setEmail(usuarioRequestDTO.getEmail());

        //Criptrografando a senha antes de salvar no banco de dados
        novoUsuario.setSenha(bCryptPasswordEncoder.encode(usuarioRequestDTO.getSenha()));

        usuarioRepository.save(novoUsuario);
        return novoUsuario;
    }

    //Atualizar os dados  ------------------------------------------------------------------
    public UsuarioModel atualizarUsuario(Long id, UsuarioRequestDTO dto) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado.");
        }

        UsuarioModel atualizarUsuario = new UsuarioModel();
        atualizarUsuario.setId(id);
        atualizarUsuario.setNome(dto.getNome());
        atualizarUsuario.setEmail(dto.getEmail());

        //Criptrografando a senha antes de salvar.
        atualizarUsuario.setSenha(bCryptPasswordEncoder.encode(dto.getSenha()));

        usuarioRepository.save(atualizarUsuario);
        return atualizarUsuario;
    }

    //Delete ------------------------------------------------------------------------------
    public void excluirUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado.");
        }

        usuarioRepository.deleteById(id);
    }

    public List<UsuarioResponseDTO> listarTodos() {
        return usuarioRepository
                //Retorna com os dados de todos os usuarios na tabela.
                .findAll()
                //Envia os dados obtidos para a proxima funções abaixo.
                .stream()
                //Envia somente os dados necessarios para a resposta.
                .map( u -> new UsuarioResponseDTO(u.getNome(), u.getEmail()))
                //Transforma todos os dados em uma Lista
                .toList();
    }
}
