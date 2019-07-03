package me.vitoremanoel.discordintegration.grants;

public enum Grants {
    AUTHORIZATION("code"),
    IMPLICIT("token");

    private final String grantType;
    Grants(String grantType) {
        this.grantType = grantType;
    }

    @Override
    public String toString(){
        return this.grantType;
    }

}