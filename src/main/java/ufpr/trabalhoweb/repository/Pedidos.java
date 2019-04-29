package ufpr.trabalhoweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ufpr.trabalhoweb.model.Pedido;

public interface Pedidos extends JpaRepository<Pedido, Integer>{

}
