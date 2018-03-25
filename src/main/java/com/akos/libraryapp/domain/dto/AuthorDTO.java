package com.akos.libraryapp.domain.dto;

import java.util.Date;

public class AuthorDTO {

    private String fullName;

    private Date birthday;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
