package com.example.three.service;

import com.example.three.model.Cliente;
import com.example.three.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> ListarTodos (){
         return clienteRepository.findAll();
    }

    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);

    }
    public Cliente atualizar(UUID id, Cliente cliente){
        if (clienteRepository.existsById(id)) {
            return clienteRepository.save(cliente);
        } else {
            throw new RuntimeException("Usuário não encontrado. ");
        }
    }

    public void excluir (UUID id) {
        clienteRepository.deleteById(id);
    }

}
