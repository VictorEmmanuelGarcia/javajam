package com.example.tri_os;

public class Name {
    public String firstname, middlename, lastname;
    public Name(){}
    public Name(String firstname, String middlename, String lastname){
        setFirstname(firstname);
        setMiddlename(middlename);
        setLastname(lastname);
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return firstname+" "+middlename+" "+lastname;
    }
}
