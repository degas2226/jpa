package com.jpa.manytomany.usrperms.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "PAA_PERMISSIONS", schema = "PUBLIC", catalog = "USRPERMS")
public class PaaPermissionsEntity {
    private int permissionId;
    private String permDesc;
    private Timestamp createdTs;
    private Timestamp updatedTs;

    private Set<PaaUsersEntity> paaUsers;

    @Id
    @Column(name = "PERMISSION_ID", nullable = false)
    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    @Basic
    @Column(name = "PERM_DESC", nullable = false, length = 250)
    public String getPermDesc() {
        return permDesc;
    }

    public void setPermDesc(String permDesc) {
        this.permDesc = permDesc;
    }

    @Basic
    @Column(name = "CREATED_TS", nullable = true)
    public Timestamp getCreatedTs() {
        return createdTs;
    }

    public void setCreatedTs(Timestamp createdTs) {
        this.createdTs = createdTs;
    }

    @Basic
    @Column(name = "UPDATED_TS", nullable = true)
    public Timestamp getUpdatedTs() {
        return updatedTs;
    }

    public void setUpdatedTs(Timestamp updatedTs) {
        this.updatedTs = updatedTs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaaPermissionsEntity that = (PaaPermissionsEntity) o;
        return permissionId == that.permissionId &&
                Objects.equals(permDesc, that.permDesc) &&
                Objects.equals(createdTs, that.createdTs) &&
                Objects.equals(updatedTs, that.updatedTs);
    }
    @ManyToMany(mappedBy = "paaPermissions")
    public Set<PaaUsersEntity> getPaaUsers() {
        return paaUsers;
    }

    public void setPaaUsers(Set<PaaUsersEntity> paaUsers) {
        this.paaUsers = paaUsers;
    }
}
