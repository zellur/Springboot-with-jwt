package com.rakib.jwt.entity;

import com.rakib.jwt.model.UserModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User extends AuditableEntity implements Serializable {

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "user_name", length = 20)
    private String userName;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "password", length = 100)
    private String password;

    public User(UserModel model) {
        this.setName(model.getName());
        this.setUserName(model.getUserName());
        this.setEmail(model.getEmail());
        this.setPassword(model.getPassword());
    }

    public User() {

    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))


    private Set<Role> roles = new HashSet<Role>();

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
