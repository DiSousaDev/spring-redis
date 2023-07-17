package br.dev.diego.springredis.records.client;

public record ClientInsertRecord(
        String name,
        String cpf,
        String email
) {}
