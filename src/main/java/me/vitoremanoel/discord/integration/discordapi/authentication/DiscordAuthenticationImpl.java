package me.vitoremanoel.discord.integration.discordapi.authentication;

import me.vitoremanoel.discord.integration.DiscordIntegration;
import me.vitoremanoel.discord.integration.discordapi.exceptions.TokenInvalidException;
import me.vitoremanoel.discord.integration.discordapi.exceptions.TokenUnAuthorizedException;
import me.vitoremanoel.discord.integration.grants.GrantType;
import me.vitoremanoel.discord.integration.scopes.Scopes;
import me.vitoremanoel.discord.integration.services.DiscordAuthenticationService;
import me.vitoremanoel.discord.integration.models.DiscordToken;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.function.BiConsumer;

class DiscordAuthenticationImpl implements DiscordAuthentication {


    private final String discord = "https://discordapp.com/";

    private DiscordAuthenticationService discordAuthenticationService;
    private Retrofit retrofit;
    private DiscordIntegration discordIntegration;
    DiscordAuthenticationImpl(DiscordIntegration discordIntegration) {
        this.discordIntegration = discordIntegration;
        this.retrofit = new Retrofit.Builder()
                .baseUrl(this.discord)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.discordAuthenticationService = retrofit.create(DiscordAuthenticationService.class);

    }

    @Override
    public void authorization(GrantType grantType, String code, BiConsumer<DiscordToken, Throwable> token) {
        Call<DiscordToken> authorizationCall = this.discordAuthenticationService.authorizationCode(this.discordIntegration.getClientId(), this.discordIntegration.getClientSecret(), grantType.toString(), code, discordIntegration.getRedirectUrl(), Scopes.toInlineString(discordIntegration.getScopes()));
        authorizationCall.enqueue(new Callback<DiscordToken>() {
            @Override
            public void onResponse(Call<DiscordToken> call, Response<DiscordToken> response) {
                if(response.isSuccessful()) token.accept(response.body(), null);
                switch (response.code()){
                    case 401:
                        token.accept(null, new TokenUnAuthorizedException("UnAuthorized Token"));
                        break;
                    case 400:
                        token.accept(null, new TokenInvalidException("Invalid token"));
                        break;
                }
            }

            @Override
            public void onFailure(Call<DiscordToken> call, Throwable t) {
                token.accept(null, t);
            }
        });
    }
}
