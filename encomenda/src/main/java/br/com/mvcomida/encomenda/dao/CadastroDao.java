package br.com.mvcomida.encomenda.dao;

import br.com.mvcomida.encomenda.model.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadastroDao extends JpaRepository<Cadastro, Integer> {
    
}
