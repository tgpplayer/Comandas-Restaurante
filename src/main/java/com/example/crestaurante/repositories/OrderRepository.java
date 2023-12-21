package com.example.crestaurante.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crestaurante.entities.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
	
}
