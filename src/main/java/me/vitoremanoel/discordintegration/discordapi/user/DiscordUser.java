package me.vitoremanoel.discordintegration.discordapi.user;

import me.vitoremanoel.discordintegration.models.DiscordToken;
import me.vitoremanoel.discordintegration.models.User;

import java.util.function.BiConsumer;

public interface DiscordUser {

    static DiscordUser of(DiscordToken userToken){
        return new DiscordUserImpl(userToken);
    }

    void getUser(BiConsumer<User, Throwable> user);

}
