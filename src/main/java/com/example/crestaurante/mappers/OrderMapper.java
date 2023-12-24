package com.example.crestaurante.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.crestaurante.dto.OrderDTO;
import com.example.crestaurante.entities.OrderEntity;

@Mapper(componentModel = "spring")
public interface OrderMapper {
	
	OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
	
	OrderDTO toDTO(OrderEntity order);
	OrderEntity toEntity(OrderDTO order);
	
	List<OrderDTO> toDTOList(List<OrderEntity> orders);
}
