package com.example.four.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.four.model.UsuarioModel;
import com.example.four.repository.UsuarioRepository;

@Service
public class UsuarioService {

   @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioModel> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public UsuarioModel salvar(UsuarioModel usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()){
          throw new IllegalArgumentException("Email já cadastrado");
        }
        return usuarioRepository.save(usuario);
    }


    // método para salvar um novo usuário
    // verifica se o email já está cadastrado antes de salvar
    //public UsuarioModel salvarUsuario(UsuarioModel usuario) {
     //if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()){
      // throw new RuntimeException("Email já cadastrado");
    // }
       // return usuarioRepository.save(usuario);
    //}

    // método para atualizar um usuário existente
    public UsuarioModel atualizarUsuario(UUID id, UsuarioModel usuario) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
        }
        usuario.setId(id);
        return usuarioRepository.save(usuario);

    }
     // método para deletar um usuário por ID
    public void deletarUsuario(UUID id) {
            if (!usuarioRepository.existsById(id)) {
                throw new RuntimeException("Usuário não encontrado");
            }
            usuarioRepository.deleteById(id);
        }
    }

    


