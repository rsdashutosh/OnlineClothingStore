package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.ReturnAndExchange;

public interface ReturnRepository extends JpaRepository<ReturnAndExchange, Integer>{

}
