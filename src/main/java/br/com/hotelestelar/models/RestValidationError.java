package br.com.hotelestelar.models;

public record RestValidationError(
    Integer code,
    String field,
    String message
) {}