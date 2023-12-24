package com.example.crestaurante.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.crestaurante.dto.RequestDTO;
import com.example.crestaurante.entities.RequestEntity;

@Mapper(componentModel = "spring")
public interface RequestMapper {
	
	RequestMapper INSTANCE = Mappers.getMapper(RequestMapper.class);
	
	RequestDTO toDTO(RequestEntity request);
}
