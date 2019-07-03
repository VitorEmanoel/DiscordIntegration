package me.vitoremanoel.discordintegration.discordapi.exceptions;

public class TokenUnAuthorizedException extends Exception {

    public TokenUnAuthorizedException(String msg){
        super(msg);
    }
}
