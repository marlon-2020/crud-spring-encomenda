package br.com.mvcomida.encomenda.model;

import br.com.mvcomida.encomenda.model.Comida;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Cadastro{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String cpf;

    @Enumerated(EnumType.STRING)
    private Comida comida;

    @Column(nullable = false)
    private String senha;
}
