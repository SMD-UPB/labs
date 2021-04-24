package com.smd.retrofitdemo.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * The response for the call to http://api.open-notify.org/astros.json
 */
public class PeopleInSpace {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("number")
    @Expose
    private int number;
    @SerializedName("people")
    @Expose
    private List<Person> people = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "PeopleInSpace{" +
                "message='" + message + '\'' +
                ", number=" + number +
                ", people=" + people +
                '}';
    }
}
