package me.vitoremanoel.discord.integration.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import me.vitoremanoel.discord.integration.scopes.Scopes;

@Data
public class DiscordToken {

    @SerializedName("access_token")
    private String accessToken;
    @SerializedName("token_type")
    private String tokenType;
    @SerializedName("expires_in")
    private Long expiresIn;
    @SerializedName("refresh_token")
    private String refreshToken;
    @SerializedName("scope")
    private Scopes scope;

}
