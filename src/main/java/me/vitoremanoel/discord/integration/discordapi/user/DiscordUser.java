package me.vitoremanoel.discord.integration.discordapi.user;

import me.vitoremanoel.discord.integration.models.DiscordToken;
import me.vitoremanoel.discord.integration.models.User;

import java.util.function.BiConsumer;

public interface DiscordUser {

    static DiscordUser of(DiscordToken userToken){
        return new DiscordUserImpl(userToken);
    }

    void getUser(BiConsumer<User, Throwable> user);

}
