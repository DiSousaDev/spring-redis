package br.dev.diego.springredis.records.client;

public record ClientFullRecord(
        Long id,
        String name,
        String cpf,
        String email
) {
}
