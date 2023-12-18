package com.example.crestaurante.controllers;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.crestaurante.dto.Pedido;

@Controller
public class WebSocketController {
	
	@MessageMapping("/pedido/{roomId}")
	@SendTo("/topic/{roomId}")
	public Pedido pedido(@DestinationVariable String roomId, Pedido pedido) {
		//
		return new Pedido(pedido.getId(), pedido.getMesa()
				, pedido.getCamarero(), pedido.getComidasBebidas(), pedido.getPrecio());
	}
}
