package com.fatec.controle_financeiro.domain.cliente;
import com.fatec.controle_financeiro.entities.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
}
