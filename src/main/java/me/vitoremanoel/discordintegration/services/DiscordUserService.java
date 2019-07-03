package me.vitoremanoel.discordintegration.services;

import me.vitoremanoel.discordintegration.models.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface DiscordUserService {

    @GET("/api/users/@me")
    Call<User> getUser(@Header("Authorization") String authorization);

}
