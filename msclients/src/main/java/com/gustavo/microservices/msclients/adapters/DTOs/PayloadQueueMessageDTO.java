package com.gustavo.microservices.msclients.adapters.DTOs;

public record PayloadQueueMessageDTO(
        String clientEmail,
        String emailSubject,
        String emailBody
) {
}
