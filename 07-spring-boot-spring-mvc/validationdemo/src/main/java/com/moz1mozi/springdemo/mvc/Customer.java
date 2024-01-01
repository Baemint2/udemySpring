package com.moz1mozi.springdemo.mvc;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {

    private String firstName;

    @NotNull(message = "is required")
    @Size(min=2, message = "is required")
    private String lastName;

    @Min(value=0, message = "must be greater then or equal to zero")
    @Max(value=10, message = "must be less then or equal to 10")
    private String freePasses;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(String freePasses) {
        this.freePasses = freePasses;
    }
}
