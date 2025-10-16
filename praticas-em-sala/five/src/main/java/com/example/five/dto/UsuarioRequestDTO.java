package com.example.five.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class UsuarioRequestDTO {

    @NotBlank(message = "O nome é obrigatorio. ")
    @Size(min = 3, message = "O nome deve ter mais de 3 caracteres.")
    private String nome;

    @NotBlank(message = "O email é obrigatorio. ")
    @Email(message = "Deve ser um email válido.")
    private String email;

    @NotBlank(message = "A senha é obrigatorio. ")
    @Size(min = 3, max =20, message = "A senha deve ter entre 3 e 20 caracteres. ")
    private String senha;

}
