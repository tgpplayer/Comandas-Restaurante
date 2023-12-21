package com.example.crestaurante.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.crestaurante.entities.WaiterEntity;

public interface WaiterRepository extends JpaRepository<WaiterEntity, Long> {
	
	@Query(value = "SELECT fullName FROM waiters WHERE code = :code", nativeQuery = true)
	public String getWaiterNameByCode(@Param("code") int code);
}
