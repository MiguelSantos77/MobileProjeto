package com.example.projetoandroid;

public class RegisterHelper {

    private String username;
    private String email;
    private String password;
    private String admin;








    RegisterHelper(){

    }

    RegisterHelper(String username, String email, String password, String admin ){
        this.username = username;
        this.email = email;
        this.password = password;
        this.admin = admin;

    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }
}
