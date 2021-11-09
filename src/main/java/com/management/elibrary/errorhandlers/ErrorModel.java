package com.management.elibrary.errorhandlers;

public class ErrorModel {

    private String fieldName;
    private String messageError;

    public ErrorModel(String fieldName, String messageError) {
        this.fieldName = fieldName;
        this.messageError = messageError;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }
}
