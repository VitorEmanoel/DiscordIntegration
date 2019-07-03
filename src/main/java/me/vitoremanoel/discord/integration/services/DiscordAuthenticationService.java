package me.vitoremanoel.discord.integration.services;

import me.vitoremanoel.discord.integration.models.DiscordToken;
import retrofit2.Call;
import retrofit2.http.*;

public interface DiscordAuthenticationService {

    @FormUrlEncoded
    @POST("/api/oauth2/token")
    Call<DiscordToken> authorizationCode(
            @Field("client_id") String clientId,
            @Field("client_secret") String clientSecret,
            @Field("grant_type") String grantType,
            @Field("code") String code,
            @Field("redirect_uri") String redirectUri,
            @Field("scope") String scope);

}
