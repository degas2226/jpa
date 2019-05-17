package com.jpa.manytomany.usrperms.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "PAA_USERS", schema = "PUBLIC", catalog = "USRPERMS")
public class PaaUsersEntity {
    private int racfId;
    private String firstName;
    private String lastName;
    private String career;

    private Set<PaaPermissionsEntity> paaPermissions;

    @Id
    @Column(name = "RACF_ID", nullable = false)
    public int getRacfId() {
        return racfId;
    }

    public void setRacfId(int racfId) {
        this.racfId = racfId;
    }

    @Basic
    @Column(name = "FIRST_NAME", nullable = false, length = 250)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LAST_NAME", nullable = false, length = 250)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "CAREER", nullable = true, length = 250)
    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaaUsersEntity that = (PaaUsersEntity) o;
        return racfId == that.racfId &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(career, that.career);
    }
    @ManyToMany
    @JoinTable(name = "PAA_PERMISSIONS_USER",joinColumns = @JoinColumn(name="RACF_ID"),
            inverseJoinColumns = @JoinColumn(name = "PERMISSION_ID"))
    public Set<PaaPermissionsEntity> getPaaPermissions() {
        return paaPermissions;
    }

    public void setPaaPermissions(Set<PaaPermissionsEntity> paaPermissions) {
        this.paaPermissions = paaPermissions;
    }
}
