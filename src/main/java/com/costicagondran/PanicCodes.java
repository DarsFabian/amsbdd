package com.costicagondran;

public enum PanicCodes {
    NO_USER_SPECIFIED(1000, "No user was specified to connect to the database..."),
    NO_PASSWORD_SPECIFIED(1001, "No password was specified to connect to the database...");

    private final int code;
    private final String description;

    private PanicCodes(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }
}
