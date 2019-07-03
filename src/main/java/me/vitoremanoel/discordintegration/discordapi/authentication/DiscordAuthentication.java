package me.vitoremanoel.discordintegration.discordapi.authentication;

import me.vitoremanoel.discordintegration.DiscordIntegration;
import me.vitoremanoel.discordintegration.grants.GrantType;
import me.vitoremanoel.discordintegration.models.DiscordToken;

import java.util.function.BiConsumer;


public interface DiscordAuthentication {

    static DiscordAuthentication of(DiscordIntegration integration){
        return new DiscordAuthenticationImpl(integration);
    }

    void authorization(GrantType grantType, String code, BiConsumer<DiscordToken, Throwable> token);

}
