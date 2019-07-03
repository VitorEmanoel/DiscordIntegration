package me.vitoremanoel.discord.integration.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class User {

    @SerializedName("id")
    private String id;

    @SerializedName("username")
    private String username;

    @SerializedName("discriminator")
    private String discriminator;

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("bot")
    private boolean bot;

    @SerializedName("mfa_enabled")
    private boolean mfaEnabled;

    @SerializedName("locale")
    private String locale;

    @SerializedName("verified")
    private boolean verified;

    @SerializedName("email")
    private String email;

    @SerializedName("flags")
    private int flags;

    @SerializedName("premium_type")
    private int premiumType;


}
