package com.spring.webApps.WepAppsProject.Details;

import java.io.Serializable;

public class Details implements Serializable {

	private static final long serialVersionUID = 1L;

	String email ;
    String Date;

    public Details() {
    }

    public Details(String email, String date) {
        this.email = email;
        this.Date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }


}
