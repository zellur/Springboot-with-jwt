package com.rakib.jwt.repository;

import com.rakib.jwt.entity.Role;
import com.rakib.jwt.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("from Role r where r.roleName = :roleName")
    public Role findByRoleName(@Param("roleName") String roleName);
}
