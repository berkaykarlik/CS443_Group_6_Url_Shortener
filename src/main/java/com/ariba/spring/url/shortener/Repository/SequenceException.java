package com.ariba.spring.url.shortener.Repository;


public class SequenceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String errCode;
    private String errMsg;

    //get, set...
    public SequenceException(String errMsg) {
        this.errMsg = errMsg;
    }

}