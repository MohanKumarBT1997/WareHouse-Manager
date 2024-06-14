package com.jsp.wm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.wm.entity.Client;


public interface ClientRepository extends JpaRepository<Client, Integer>{

}
