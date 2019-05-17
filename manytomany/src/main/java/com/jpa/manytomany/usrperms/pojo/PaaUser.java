package com.jpa.manytomany.usrperms.pojo;

import java.util.Set;

public class PaaUser {
    private int racfId;
    private String firstName;
    private String lastName;
    private String career;
    private Set<PaaPermission> permissions;

    public int getRacfId() {
        return racfId;
    }

    public void setRacfId(int racfId) {
        this.racfId = racfId;
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

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public Set<PaaPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<PaaPermission> permissions) {
        this.permissions = permissions;
    }
}
