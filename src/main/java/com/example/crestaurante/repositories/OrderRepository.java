package com.example.crestaurante.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.crestaurante.dto.BillDTO;
import com.example.crestaurante.entities.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
	
	@Query(value = "INSERT INTO orders VALUES(:requestId, :productId)", nativeQuery = true)
	public void addProductsToTable(long requestId, long productId);
	
	@Query(value = "SELECT product, price FROM products "
			+ "JOIN orders ON products.id = orders.product_id"
			+ "JOIN requests ON requests.id = orders.request_id"
			+ "WHERE requests.table = :table && requests.finished = 0", nativeQuery = true)
	public List<BillDTO> getAllOrdersFromTable(int table);
}
