package com.example.tri_os;

public class User{
    public String email;
    public Name name;
    public User(){}
    public User(String email, Name name){
        setEmail(email);
        setName(name);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
