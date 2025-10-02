package com.example.four.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.four.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, UUID> {
    // método personalizado para buscar usuário por email
    // retorna um Optional para lidar com o caso de não encontrar o usuário
    Optional<UsuarioModel> findByEmail(String email);

}
