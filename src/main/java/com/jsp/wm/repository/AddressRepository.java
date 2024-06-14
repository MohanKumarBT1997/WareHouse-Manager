package com.jsp.wm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.wm.entity.Address;
import com.jsp.wm.entity.WareHouse;

public interface AddressRepository extends JpaRepository<Address,Integer >{

	public List<Address> findWarehousesByCity(String city);

}
