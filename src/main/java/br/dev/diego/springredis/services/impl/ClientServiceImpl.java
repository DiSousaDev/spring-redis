package br.dev.diego.springredis.services.impl;

import br.dev.diego.springredis.entities.Client;
import br.dev.diego.springredis.mappers.ClientMapper;
import br.dev.diego.springredis.records.client.ClientFullRecord;
import br.dev.diego.springredis.records.client.ClientInsertRecord;
import br.dev.diego.springredis.records.client.ClientShortRecord;
import br.dev.diego.springredis.repositories.ClientRepository;
import br.dev.diego.springredis.services.ClientService;
import br.dev.diego.springredis.services.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientFullRecord save(ClientInsertRecord clientInsert) {
        Client client = clientMapper.clientInsertRecordToClient(clientInsert);
        Client clientSaved = clientRepository.save(client);
        return clientMapper.clientToClientFullRecord(clientSaved);
    }

    @Override
    public List<ClientShortRecord> listClients() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::clientToClientShortRecord)
                .toList();
    }

    @Override
    public ClientFullRecord findById(Long id) {
        Client client = getClientById(id);
        return clientMapper.clientToClientFullRecord(client);
    }

    @Override
    public void deleteById(Long id) {
        getClientById(id);
        clientRepository.deleteById(id);
    }

    private Client getClientById(Long id) {
        return clientRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format("Client ID:[%s] not found! Try again...", id)));
    }
}
