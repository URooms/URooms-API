package com.upc.uroomsapi.model.response;

/**
 * Muestra los mensajes (error/exito) para el cliente
 */
public class MessageResponse {
    private String message;

    public MessageResponse() {}
    public MessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
