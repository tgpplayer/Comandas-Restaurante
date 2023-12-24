package com.example.crestaurante.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.crestaurante.entities.RequestEntity;

public interface RequestRepository extends JpaRepository<RequestEntity, Long> {
	
	@Query(value = "UPDATE requests SET finished = true WHERE table = :table", nativeQuery = true)
	public void setTableToFinished(@Param("table") int table);
	
	@Query(value = "SELECT * FROM requests WHERE table = :table", nativeQuery = true)
	public RequestEntity getRequest(int table);
	
	@Query(value = "SELECT table FROM requests WHERE finished = false", nativeQuery = true)
	public List<Integer> getUnfinishedTables();
}
