package me.vitoremanoel.discordintegration.discordapi.user;

import lombok.Getter;
import me.vitoremanoel.discordintegration.discordapi.exceptions.TokenUnAuthorizedException;
import me.vitoremanoel.discordintegration.models.DiscordToken;
import me.vitoremanoel.discordintegration.models.User;
import me.vitoremanoel.discordintegration.services.DiscordUserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.function.BiConsumer;

class DiscordUserImpl implements DiscordUser{

    private final String discord = "https://discordapp.com/";

    @Getter
    private final DiscordToken token;

    private final Retrofit retrofit;
    private final DiscordUserService discordUserService;
    DiscordUserImpl(DiscordToken userToken) {
        this.token = userToken;
        this.retrofit = new Retrofit.Builder()
                .baseUrl(this.discord)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.discordUserService = retrofit.create(DiscordUserService.class);
    }

    @Override
    public void getUser(BiConsumer<User, Throwable> user) {
        Call<User> getUserCall = this.discordUserService.getUser(String.format("%s %s", this.token.getTokenType(), this.token.getAccessToken()));
        getUserCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) user.accept(response.body(), null);
                switch (response.code()){
                    case 401:
                        user.accept(null, new TokenUnAuthorizedException("Token UnAuthorization"));
                        break;
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                user.accept(null, t);
            }
        });

    }
}
