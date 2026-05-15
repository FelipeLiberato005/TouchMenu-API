package com.example.Testando123.Filtr;

import com.example.Testando123.Exceptions.EmailInvalido;

public class FiltroEmail {

    public boolean filtraTel(String message) throws EmailInvalido {
        String regex = "\\w+@\\w+.[a-z].[a-z]*.[a-z]*";
        boolean matches = message.matches(regex);
        if(matches != true)
        {
            throw new EmailInvalido();
        }
        return matches;

    }
}
