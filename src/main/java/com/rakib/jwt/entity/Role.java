package com.rakib.jwt.entity;

import com.rakib.jwt.enums.RoleName;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends AuditableEntity{

    @Column(name = "role", length = 60)
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
