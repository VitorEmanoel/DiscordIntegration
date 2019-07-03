package me.vitoremanoel.discord.integration.discordapi.authentication;

import me.vitoremanoel.discord.integration.DiscordIntegration;
import me.vitoremanoel.discord.integration.grants.GrantType;
import me.vitoremanoel.discord.integration.models.DiscordToken;

import java.util.function.BiConsumer;
import java.util.function.Function;


public interface DiscordAuthentication {

    static DiscordAuthentication of(DiscordIntegration integration){
        return new DiscordAuthenticationImpl(integration);
    }

    void authorization(GrantType grantType, String code, BiConsumer<DiscordToken, Throwable> token);

}
