package me.vitoremanoel.discord.integration.discordapi.exceptions;

public class TokenUnAuthorizedException extends Exception {

    public TokenUnAuthorizedException(String msg){
        super(msg);
    }
}
