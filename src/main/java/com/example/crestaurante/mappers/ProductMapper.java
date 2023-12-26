package com.example.crestaurante.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.crestaurante.dto.ProductDTO;
import com.example.crestaurante.entities.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductMapper {
	
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
	
	List<ProductDTO> toDTOList(List<ProductEntity> entity);
}
