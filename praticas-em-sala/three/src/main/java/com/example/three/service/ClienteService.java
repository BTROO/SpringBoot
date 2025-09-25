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

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> ListarTodos (){
         return clienteRepository.findAll();
    }

    public Cliente salvar(Cliente cliente){
        //verificar se o funcionario ja esta cadastrado.
        if(clienteRepository.findByTelefone(cliente.getTelefone()).isPresent()){
            //se encontrado o  telefone do cliente no banco de dados, mostra mensagem
            throw new RuntimeException("Cliente já cadastrado");
        }
        //caso encontre o telefone no bd
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
