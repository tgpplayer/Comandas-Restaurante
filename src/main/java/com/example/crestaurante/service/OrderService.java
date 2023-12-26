package com.example.crestaurante.service;

import java.util.List;

import com.example.crestaurante.dto.BillDTO;
import com.example.crestaurante.dto.OrderDTO;
import com.example.crestaurante.dto.TopRankedProductDTO;

public interface OrderService {
	
	void saveOrder(OrderDTO order);
	List<BillDTO> getAllOrdersFromTable(int table);
	void addProductsToTable(long requestId, long productId);
	List<TopRankedProductDTO> getTopRankedProducts();
}
