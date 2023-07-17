package br.dev.diego.springredis.mappers;

import br.dev.diego.springredis.entities.Client;
import br.dev.diego.springredis.records.client.ClientFullRecord;
import br.dev.diego.springredis.records.client.ClientInsertRecord;
import br.dev.diego.springredis.records.client.ClientShortRecord;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client clientInsertRecordToClient(ClientInsertRecord client);
    ClientFullRecord clientToClientFullRecord(Client client);
    ClientShortRecord clientToClientShortRecord(Client client);

}
