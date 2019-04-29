package ufpr.trabalhoweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ufpr.trabalhoweb.model.Produto;

public interface Produtos extends JpaRepository<Produto, Integer>{

}
