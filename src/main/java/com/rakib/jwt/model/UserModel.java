package com.rakib.jwt.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rakib.jwt.entity.Role;
import com.rakib.jwt.entity.User;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UserModel implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String name;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String userName;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String email;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String password;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<Role> roles;

    public UserModel(User user) {
        this.setId(user.getId());
        this.setName(user.getName());
        this.setUserName(user.getUserName());
        this.setEmail(user.getEmail());
        this.setPassword(user.getPassword());
        this.setRoles(user.getRoles());
    }

    public UserModel() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
