package com.example.crestaurante.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.crestaurante.dto.BillDTO;
import com.example.crestaurante.dto.TopRankedProductDTO;
import com.example.crestaurante.entities.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
	
	@Query(value = "INSERT INTO orders VALUES(:requestId, :productId)", nativeQuery = true)
	public void addProductsToTable(@Param("requestId") long requestId, @Param("productId") long productId);
	
	@Query(value = "SELECT product, price FROM products "
			+ "JOIN orders ON products.id = orders.product_id "
			+ "JOIN requests ON requests.id = orders.request_id "
			+ "WHERE requests.table_number = :table && requests.finished = 0", nativeQuery = true)
	public List<BillDTO> getAllOrdersFromTable(@Param("table") int table);
	
	@Query(value = "SELECT * FROM products JOIN orders ON products.id = orders.product_id", nativeQuery = true)
	public List<Long> getAllProductsOrdered();
	
	@Query(value = "SELECT products.*, COUNT(*) AS times_ordered FROM products "
			+ "JOIN orders ON products.id = orders.product_id "
			+ "GROUP BY products.id HAVING COUNT(*) > 0 "
			+ "ORDER BY times_ordered DESC", nativeQuery = true)
	public List<TopRankedProductDTO> getTopRankedProducts();
}
