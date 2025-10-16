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


    public UsuarioModel salvarUsuario(UsuarioRequestDTO usuarioRequestDTO){
    if (usuarioRepository.findByEmail(usuarioRequestDTO.getEmail()).isPresent()) {
            throw  new IllegalArgumentException("Usuario já cadastrado");

        }

    UsuarioModel usuario = new UsuarioModel();
    usuario.setNome(usuarioRequestDTO.getNome());
    usuario.setEmail(usuarioRequestDTO.getEmail());

    //Criptrografar a senha antes de salvar no banco de dados
        usuario.setSenha(bCryptPasswordEncoder.encode(usuarioRequestDTO.getSenha()));

        usuarioRepository.save(usuario);
        return usuario;

    }

    //consultar o banco de dados

    public List<UsuarioResponseDTO> ListarTodos(){
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
