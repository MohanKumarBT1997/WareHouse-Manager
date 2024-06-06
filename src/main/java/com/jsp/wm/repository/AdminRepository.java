package com.jsp.wm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.wm.entity.Admin;
import com.jsp.wm.enums.AdminType;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	public boolean existsByAdminType(AdminType adminType);

	public Optional<Admin> findByEmail(String username);

}
