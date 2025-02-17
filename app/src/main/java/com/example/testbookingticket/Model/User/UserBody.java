package com.example.testbookingticket.Model.User;

import com.google.gson.annotations.SerializedName;

public class UserBody {
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserBody(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
