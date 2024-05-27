package com.example.pruba.repository;


import com.example.pruba.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class RepositoryCliente {

    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> getAll(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getId(Integer clienteId){
        return clienteRepository.findById(clienteId);
    }

    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public void delete(Integer clienteId) {
        clienteRepository.deleteById(clienteId);
    }
}

