package com.smd.retrofitdemo.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * A person in space, as defined by the API response
 */
public class Person {

    @SerializedName("craft")
    @Expose
    private String craft;
    @SerializedName("name")
    @Expose
    private String name;

    public String getCraft() {
        return craft;
    }

    public void setCraft(String craft) {
        this.craft = craft;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "craft='" + craft + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
