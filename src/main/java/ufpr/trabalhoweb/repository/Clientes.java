package ufpr.trabalhoweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ufpr.trabalhoweb.model.Cliente;

public interface Clientes extends JpaRepository<Cliente, Integer>{

}
