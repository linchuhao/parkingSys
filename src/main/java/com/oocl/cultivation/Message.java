package com.oocl.cultivation;

public class Message {
    /*
            success: true
            fail: false
             */
    private boolean result;

    private String message;

    private String ticketToken;

    public String getTicketToken() {
        return ticketToken;
    }

    public void setTicketToken(String ticketToken) {
        this.ticketToken = ticketToken;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
