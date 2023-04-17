package br.com.fiap.hotelestelar.models;

public record RestValidationError(
    Integer code,
    String field,
    String message
) {}