package com.agroho.authorrest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rezaul on 09-Sep-16.
 */
public class Author {

    @SerializedName("authorId")
    Long authorId;

    @SerializedName("id")
    String id;

    @SerializedName("firstName")
    String firstName;

    @SerializedName("lastName")
    String lastName;

    public Author(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
}
