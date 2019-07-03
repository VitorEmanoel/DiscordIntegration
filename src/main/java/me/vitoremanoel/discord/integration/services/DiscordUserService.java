package me.vitoremanoel.discord.integration.services;

import me.vitoremanoel.discord.integration.models.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface DiscordUserService {

    @GET("/api/users/@me")
    Call<User> getUser(@Header("Authorization") String authorization);

}
