package br.com.mvcomida.encomenda.model;

import br.com.mvcomida.encomenda.model.Comida;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Cadastro{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 100)
    @NotEmpty(message = "Nome obrigatório!")
    private String nome;

    @Column(nullable = false, length = 100)
    @NotEmpty(message = "CPF obrigatório!")
    private String cpf;

    @Enumerated(EnumType.STRING)
    private Comida comida;

    @Column(nullable = false)
    private String senha;
}
