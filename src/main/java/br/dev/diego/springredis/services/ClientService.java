package br.dev.diego.springredis.services;

import br.dev.diego.springredis.records.client.ClientFullRecord;
import br.dev.diego.springredis.records.client.ClientInsertRecord;
import br.dev.diego.springredis.records.client.ClientShortRecord;

import java.util.List;

public interface ClientService {

    ClientFullRecord save(ClientInsertRecord client);
    List<ClientShortRecord> listClients();
    ClientFullRecord findById(Long id);
    void deleteById(Long id);

}
