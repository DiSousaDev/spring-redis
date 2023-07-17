package br.dev.diego.springredis.controllers;

import br.dev.diego.springredis.records.client.ClientFullRecord;
import br.dev.diego.springredis.records.client.ClientInsertRecord;
import br.dev.diego.springredis.records.client.ClientShortRecord;
import br.dev.diego.springredis.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/clients")
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientShortRecord>> findAll() {
        return ResponseEntity.ok(clientService.listClients());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientFullRecord> findById(@PathVariable Long id) {
        ClientFullRecord obj = clientService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<ClientFullRecord> insert(@RequestBody ClientInsertRecord clientRequest) {
        ClientFullRecord obj = clientService.save(clientRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.id()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        clientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
