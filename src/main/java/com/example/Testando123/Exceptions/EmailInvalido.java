package com.example.Testando123.Exceptions;

public class EmailInvalido extends Exception{

    public EmailInvalido() {
        System.out.println("Email Invalido!");
    }

    public EmailInvalido(String message) {
        super(message);
    }
}
