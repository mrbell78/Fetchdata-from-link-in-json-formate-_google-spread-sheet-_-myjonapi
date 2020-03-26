package com.nurhossen.fetchjsondatafromlink;

public class Datamodel {

    String name;
    String password;
    String contatct;
    String country;


    public Datamodel(String name, String password, String contatct, String country) {
        this.name = name;
        this.password = password;
        this.contatct = contatct;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getContatct() {
        return contatct;
    }

    public String getCountry() {
        return country;
    }
}
