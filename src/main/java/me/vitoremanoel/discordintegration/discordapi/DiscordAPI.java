package me.vitoremanoel.discordintegration.discordapi;

import me.vitoremanoel.discordintegration.DiscordIntegration;
import me.vitoremanoel.discordintegration.discordapi.authentication.DiscordAuthentication;
import me.vitoremanoel.discordintegration.discordapi.user.DiscordUser;
import me.vitoremanoel.discordintegration.models.DiscordToken;

public class DiscordAPI {

    public static DiscordAuthentication getAuthentication(DiscordIntegration discordIntegration){
        return DiscordAuthentication.of(discordIntegration);
    }

    public static DiscordUser getDiscordUser(DiscordToken token){
        return DiscordUser.of(token);
    }

}
