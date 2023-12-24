package com.example.crestaurante.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.crestaurante.dto.WaiterDTO;
import com.example.crestaurante.entities.WaiterEntity;

@Mapper(componentModel = "spring")
public interface WaiterMapper {

	WaiterMapper INSTANCE = Mappers.getMapper(WaiterMapper.class);
	
	WaiterDTO toDTO(WaiterEntity order);
}
