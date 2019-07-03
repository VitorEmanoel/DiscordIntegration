package me.vitoremanoel.discordintegration;

import me.vitoremanoel.discord.integration.discordapi.DiscordAPI;
import me.vitoremanoel.discord.integration.grants.GrantType;
import me.vitoremanoel.discord.integration.grants.Grants;
import me.vitoremanoel.discord.integration.DiscordIntegration;
import me.vitoremanoel.discord.integration.scopes.Scopes;

public class DiscordIntegrationTest {

    public static void main(String[] args){
        DiscordIntegration integration = DiscordIntegration.of(Grants.AUTHORIZATION, "579429461490139151", "zt7QvRsn6PswSafjN3sccqfPZ-tjyte0")
            .addScope(Scopes.EMAIL)
            .addScope(Scopes.IDENTIFY)
            .setRedirectURL("https://auth.developernation.com.br");
       DiscordAPI.getAuthentication(integration)
               .authorization( GrantType.AUTHORIZATION_CODE, "cZKBs7KwgENAdNIai3X5jdLQzEzsHt", (token, err) -> {
                   if (err != null){
                       err.printStackTrace();
                       return;
                   }
                   System.out.println(token);
                   System.out.println(token.getAccessToken());
                   DiscordAPI.getDiscordUser(token).getUser((user, error) -> {
                       if (error != null){
                           error.printStackTrace();
                           return;
                       }
                       System.out.println(user.getUsername());
                       System.out.println(user.getEmail());
                       System.out.println(user.getDiscriminator());
                   });
               });
    }

}
