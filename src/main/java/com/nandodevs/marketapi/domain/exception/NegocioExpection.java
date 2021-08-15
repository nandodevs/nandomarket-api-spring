package com.nandodevs.marketapi.domain.exception;

public class NegocioExpection extends RuntimeException{
    
    private static final long serialVersionUID = 1L;

    public NegocioExpection(String message){
        super(message);
    }

}
