package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Shipping;

public interface ShippingRepository extends JpaRepository<Shipping, Integer>{

}
