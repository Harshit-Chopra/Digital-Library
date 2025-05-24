package com.example.Library.exception;

    public class TxnException extends RuntimeException{
        public TxnException(String msg){
            super(msg);
        }
    }
