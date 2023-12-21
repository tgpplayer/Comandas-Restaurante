package com.example.crestaurante.controllers;

import java.util.ArrayList;
import java.util.HashMap;
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

import com.example.crestaurante.dto.OrderDTO;
import com.example.crestaurante.dto.ProductDTO;
import com.example.crestaurante.dto.RequestDTO;
import com.example.crestaurante.service.OrderService;

@Controller
public class OrdersController {
	
	@Autowired
	private OrderService oService;
	
	// TODO: Once the bill is payed, delete the customer's order? Waiters Tables? Top ranked dishes?
	
	@MessageMapping("/pedido/{roomId}")
	@SendTo("/topic/{roomId}")
	public ResponseEntity<List<String>> order(@DestinationVariable String roomId, RequestDTO request, List<ProductDTO> products) {
		
		List<String> dishes = new ArrayList<String>();
		
		for(ProductDTO product: products) {
			
			// We create orders for the later total payment of a table
			OrderDTO order = new OrderDTO();
			order.setRequest(request);
			order.setProduct(product);
			
			oService.saveOrder(order);
			
			// We strictly select food to be sent to the kitchen, not drinks
			if(product.getCategory() == "dish") {
				dishes.add(product.getProduct());
			}
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(dishes);
	}
	
	@GetMapping("/get-bill")
	public ResponseEntity<HashMap<String, Double>> getBillFromTable(@RequestParam int table) {
		List<OrderDTO> totalOrders = oService.getAllOrders();
		HashMap<String, Double> specificTableOrders = new HashMap<String, Double>();
		
		// We run over the orders to identify which ones belong to the table specified
		// Then, we take out the products and its price to make the bill for that table
		for(OrderDTO order: totalOrders) {
			if(order.getRequest().getTable() == table) {
				specificTableOrders.put(order.getProduct().getProduct(), order.getProduct().getPrice());
			}
		}
		
		// We set finished table to 'true' to not continue showing the table and its orders
		// at the Android screen
//		for(OrderDTO order: totalOrders) {
//			if(order.getRequest().getTable() == table) {
//				order.getRequest().setFinished(true);
//				break;
//			}
//		}
		return ResponseEntity.status(HttpStatus.OK).body(specificTableOrders);
	}
	
	// TODO: Show the tables that are not finished
	@GetMapping("/get-unfinished-tables")
	public ResponseEntity<List<Integer>> getUnfinishedTables() {
		List<Integer> tables = new ArrayList<Integer>();
		
		// This 'for' is an algorithm which identifies the tables that are not finished yet
		for(OrderDTO order: oService.getAllOrders()) {
			boolean alreadyIn = false;
			
			if(order.getRequest().isFinished() == false) {
				if(tables.size() > 1) {
					for(Integer i: tables) {
						if(order.getRequest().getTable() == i) {
							alreadyIn = true;
							break;
						}
					}
					if(alreadyIn == false) {
						tables.add(order.getRequest().getTable());
					}
				} else {
					tables.add(order.getRequest().getTable());
				}
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(tables);
	}

}
