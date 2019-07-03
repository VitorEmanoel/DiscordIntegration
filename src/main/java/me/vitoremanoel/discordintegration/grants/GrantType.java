package me.vitoremanoel.discordintegration.grants;

public enum GrantType {
    AUTHORIZATION_CODE("authorization_code"),
    REFRESH_TOKE("refresh_token");

    private final String grantType;
    GrantType(String grantType) {
        this.grantType = grantType;
    }

    @Override
    public String toString(){
        return this.grantType;
    }
}
