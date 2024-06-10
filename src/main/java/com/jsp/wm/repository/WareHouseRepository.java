package com.jsp.wm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.wm.entity.WareHouse;

public interface WareHouseRepository extends JpaRepository<WareHouse, Integer>  {

	public Optional<WareHouse> findById(int wareHouseId);

}
