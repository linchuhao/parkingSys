package com.oocl.cultivation;

public class Message {
    /*
            success: true
            fail: false
             */
    private boolean result;

    private String message;

    private String ticketToken;

    public Message(boolean result, String message, String ticketToken) {
        this.result = result;
        this.message = message;
        this.ticketToken = ticketToken;
    }

    public Message(boolean result, String message) {
        this.result = result;
        this.message = message;
    }

    public static Message successMessageWithTicket(String successMessage, String ticketToken) {
        return new Message(true, successMessage, ticketToken);
    }

    public static Message successMessage(String successMessage) {
        return new Message(true, successMessage);
    }

    public static Message failedMessage(String errorMessage) {
        return new Message(false, errorMessage);
    }

    public String getTicketToken() {
        return ticketToken;
    }

    public boolean isResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }
}
