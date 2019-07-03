package me.vitoremanoel.discordintegration;

import lombok.Getter;
import me.vitoremanoel.discordintegration.grants.Grants;
import me.vitoremanoel.discordintegration.scopes.Scopes;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiscordIntegration {

    public static DiscordIntegration of(Grants grants, String clientId, String clientSecret){
        return new DiscordIntegration(grants, clientId, clientSecret);
    }

    private final String discordOAuthAuthorize = "https://discordapp.com/api/oauth2/authorize?response_type=%s&client_id=%s&scope=%s&redirect_uri=%s";

    @Getter
    private final Grants grantType;
    @Getter
    private final List<Scopes> scopes;
    private String state;
    @Getter
    private String redirectUrl;
    @Getter
    private String clientId;
    @Getter
    private String clientSecret;
    private DiscordIntegration(Grants grantType, String clientId, String clientSecret){
        this.grantType = grantType;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.scopes = new ArrayList<>();
    }

    public DiscordIntegration addScope(Scopes scope){
        this.scopes.add(scope);
        return this;
    }

    public DiscordIntegration setScopes(Scopes... scopes){
        this.scopes.addAll(Arrays.asList(scopes));
        return this;
    }

    public DiscordIntegration setRedirectURL(String url){
        this.redirectUrl = url;
        return this;
    }

    public DiscordIntegration setState(String state){
        this.state = state;
        return this;
    }

    public URL getIntegrationURL() throws MalformedURLException {
        String urlString = String.format(this.discordOAuthAuthorize, this.grantType.toString(), this.clientId, Scopes.toString(this.scopes), this.redirectUrl);
        if (state != null)
            urlString += String.format("&state=%s", this.state);
        return new URL(urlString);
    }

}
