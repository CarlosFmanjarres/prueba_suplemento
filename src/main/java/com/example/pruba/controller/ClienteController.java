package com.example.pruba.controller;

import com.example.pruba.entity.Cliente;
import com.example.pruba.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.clienteService.getAll());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping("/id/{clienteId}")
    public ResponseEntity<?> getId(
            @PathVariable("clienteId") Integer clienteId) {
        try {
            Optional<Cliente> cliente = clienteService.getId(clienteId);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(cliente);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Cliente cliente) {
        try {
            Cliente saveCliente = clienteService.save(cliente);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(saveCliente);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @DeleteMapping("/delete/{clienteId}")
    public ResponseEntity<?> delete(
            @PathVariable("clienteId") Integer clienteId) {
        try {
            boolean deleted = clienteService.delete(clienteId);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(deleted);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

}
