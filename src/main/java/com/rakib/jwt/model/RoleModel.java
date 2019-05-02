package com.rakib.jwt.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rakib.jwt.entity.Role;

import java.io.Serializable;

public class RoleModel implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String roleName;

    public RoleModel(Role role) {
        this.setId(role.getId());
        this.setRoleName(role.getRoleName().toString());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
