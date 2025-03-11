package com.ecom.sb_ecom_application.repositories;

import com.ecom.sb_ecom_application.model.AppRole;
import com.ecom.sb_ecom_application.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(AppRole appRole);
}
