package com.example.crestaurante.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crestaurante.entities.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
	
	// TODO: Crear consulta que permita devolver todos los PLATOS de una determinada mesa
	// para enviarlos a cocina
	
}
