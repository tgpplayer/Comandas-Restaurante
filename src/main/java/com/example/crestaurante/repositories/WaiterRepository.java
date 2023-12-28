package com.example.crestaurante.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.crestaurante.dto.TopRankedWaiterDTO;
import com.example.crestaurante.entities.WaiterEntity;

public interface WaiterRepository extends JpaRepository<WaiterEntity, Long> {
	
	@Query(value = "SELECT * FROM waiters WHERE code = :code", nativeQuery = true)
	public WaiterEntity getWaiterByCode(@Param("code") int code);
	
	@Query(value = "SELECT waiters.full_name, COUNT(*) AS attended_tables FROM waiters "
			+ "JOIN requests ON requests.waiter_id = waiters.id "
			+ "WHERE requests.order_date >= :fRange && requests.order_date <= :sRange "
			+ "GROUP BY waiters.id HAVING COUNT(*) > 0 "
			+ "ORDER BY attended_tables DESC", nativeQuery = true)
	public List<TopRankedWaiterDTO> getTopRankedWaitersInATimeRange(@Param("fRange") LocalDate fRange, @Param("sRange") LocalDate sRange);
}
