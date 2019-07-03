package me.vitoremanoel.discord.integration.scopes;

import java.util.List;

public enum Scopes {
    BOT("bot"),
    CONNECTIONS("connections"),
    EMAIL("email"),
    IDENTIFY("identify"),
    GUILDS("guilds"),
    GUILDS_JOIN("guilds.join"),
    GMD_JOIN("gmd.join"),
    MESSAGES_READ("messages.read"),
    RPC("rpc"),
    RPC_API("rpc.api"),
    RPC_NOTIFICATION_READ("rpc.notifications.read"),
    WEBHOOK_INCOMING("webhook.incomig");

    private final String scope;
    Scopes(String scope) {
        this.scope = scope;
    }

    @Override
    public String toString(){
        return this.scope;
    }

    public static String toString(List<Scopes> scopes){
        StringBuilder finalScopeString = new StringBuilder();
        for(int i = 0; i < scopes.size(); i++){
            finalScopeString.append(scopes.get(i).toString());
            if (i < scopes.size() - 1) finalScopeString.append("%20");
        }
        return finalScopeString.toString();
    }

    public static String toInlineString(List<Scopes> scopes){
        StringBuilder finalInlineString = new StringBuilder();
        for(int i = 0; i < scopes.size(); i++){
            finalInlineString.append(scopes.get(i).toString());
            if (i < scopes.size() - 1) finalInlineString.append(" ");
        }
        return finalInlineString.toString();
    }
}
