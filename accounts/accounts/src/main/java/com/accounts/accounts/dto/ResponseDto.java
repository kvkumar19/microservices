package com.accounts.accounts.dto;


public class ResponseDto<T>  {


    private int responseCode;
    private String responseMessage;
    private T responseData;

    public ResponseDto() {
        super();
    }

    public ResponseDto(int responseCode, String responseMessage) {
        super();
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }


    public ResponseDto(int responseCode, String responseMessage, T responseData) {
        super();
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.responseData = responseData;
    }

    public T getResponseData() {
        return responseData;
    }

    public void setResponseData(T responseData) {
        this.responseData = responseData;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }



}
