package com.devsuperior.desafioclientes.controllers;

import com.devsuperior.desafioclientes.dto.ClientDTO;
import com.devsuperior.desafioclientes.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
        ClientDTO dto = clientService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> findAll(Pageable pageable) {
        Page<ClientDTO> dto = clientService.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ClientDTO insert(@Valid @RequestBody ClientDTO clientDTO) {
        return clientService.insert(clientDTO);
    }

    @PutMapping(value = "{id}")
    public ClientDTO modify(@PathVariable Long id, @Valid @RequestBody ClientDTO clientDTO) {
        return clientService.modify(id, clientDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        clientService.deleteById(id);
    }
}
