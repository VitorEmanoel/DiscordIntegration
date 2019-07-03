package me.vitoremanoel.discord.integration.discordapi;

import me.vitoremanoel.discord.integration.DiscordIntegration;
import me.vitoremanoel.discord.integration.discordapi.authentication.DiscordAuthentication;
import me.vitoremanoel.discord.integration.discordapi.user.DiscordUser;
import me.vitoremanoel.discord.integration.models.DiscordToken;

public class DiscordAPI {

    public static DiscordAuthentication getAuthentication(DiscordIntegration discordIntegration){
        return DiscordAuthentication.of(discordIntegration);
    }

    public static DiscordUser getDiscordUser(DiscordToken token){
        return DiscordUser.of(token);
    }

}
