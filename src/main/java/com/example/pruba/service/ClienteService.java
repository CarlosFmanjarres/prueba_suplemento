package com.example.pruba.service;

import com.example.pruba.entity.Cliente;
import com.example.pruba.repository.ClienteRepository;
import com.example.pruba.repository.RepositoryCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {

    @Autowired
    RepositoryCliente repositoryCliente;

    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> getAll() throws Exception {

        try {
            //validaciones
            return this.repositoryCliente.getAll();
        } catch (Exception error) {
            throw new Exception("parce no dio el gatAll");
        }
    }

    public Optional<Cliente> getId(Integer clienteId) throws Exception {

        try {
            //validaciones
            return this.repositoryCliente.getId(clienteId);
        } catch (Exception error) {
            throw new Exception("parce no dio el getId");
        }
    }

 /*   public Cliente save (Cliente cliente) throws Exception {
        try {
            //validaciones
            return this.repositoryCliente.save(cliente);
        } catch (Exception error) {
            throw new Exception("parce no dio el save");
        }
    }
*/

    public Cliente save (Cliente cliente) throws Exception {
        return this.repositoryCliente.save(cliente);
    }

    public boolean delete(Integer clienteId) {
        return clienteRepository.findById(clienteId)
                .map(cliente -> {
                    clienteRepository.delete(cliente);
                    return true;
                })
                .orElse(false);
    }


}
