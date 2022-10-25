
package com.estudio_credito_preaprobado.estudio_credito.payload.response;


public class MensajeResponse {
    
    private String statusCode;
    private String statusMessage;
    private String messageId;

    public MensajeResponse() {
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    @Override
    public String toString() {
        return "MensajeResponse{" + "statusCode=" + statusCode + ", statusMessage=" + statusMessage + ", messageId=" + messageId + '}';
    }
    
    
    

}
