package com.jsp.wm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.wm.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer>  {

	public Optional<Warehouse> findById(int warehouseId);

}
