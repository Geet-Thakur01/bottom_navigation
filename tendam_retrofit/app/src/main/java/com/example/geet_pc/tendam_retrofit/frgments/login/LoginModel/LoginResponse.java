
package com.example.geet_pc.tendam_retrofit.frgments.login.LoginModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("result")
    @Expose
    private Boolean result;
    @SerializedName("value")
    @Expose
    private Value value;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("path")
    @Expose
    private Path path;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }


}
