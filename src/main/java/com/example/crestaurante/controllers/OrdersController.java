package com.example.crestaurante.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.crestaurante.dto.BillDTO;
import com.example.crestaurante.dto.OrderDTO;
import com.example.crestaurante.dto.ProductDTO;
import com.example.crestaurante.dto.RequestDTO;
import com.example.crestaurante.service.OrderService;
import com.example.crestaurante.service.RequestService;

@Controller
public class OrdersController {
	
	@Autowired
	private OrderService oService;
	
	@Autowired
	private RequestService rService;
	
	// TODO: Once the bill is payed, store the orders 2 days. Waiters Tables? Top ranked dishes?
	// Redirect drinks to the bar man via ticket
	@MessageMapping("/pedido/{roomId}")
	@SendTo("/topic/{roomId}")
	public List<String> order(@DestinationVariable String roomId, RequestDTO request, List<ProductDTO> products) {
		
		List<String> dishes = new ArrayList<String>();
		RequestDTO possibleExistingRequest = rService.getRequest(request.getTable());
		
		// This 'for' creates a new order with a new request in case the table is free,
		// otherwise it will add the new products ordered to the table's bill that is still
		// eating, with the same 'Request'(id, table, waiter)
		for(ProductDTO product: products) {
			if(possibleExistingRequest.isFinished()) {
				// We create orders for the later total payment of a table
				OrderDTO order = new OrderDTO();
				order.setRequest(request);
				order.setProduct(product);
				
				oService.saveOrder(order);
				
			} else {
				oService.addProductsToTable(request.getId(), product.getId());
			}
			
			// We strictly select food to be sent to the kitchen, not drinks
			if(product.getCategory().equalsIgnoreCase("dish")) {
				dishes.add(product.getProduct());
			}
			
		}
		
		return dishes;
	}
	
	// This method returns the total products that a specific table has ordered and their price
	@GetMapping("/get-bill")
	public ResponseEntity<List<BillDTO>> getBillFromTable(@RequestParam int table) {
		List<BillDTO> specificTableOrders = oService.getAllOrdersFromTable(table);
		
		return ResponseEntity.status(HttpStatus.OK).body(specificTableOrders);
	}

}
