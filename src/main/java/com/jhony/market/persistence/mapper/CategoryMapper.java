package com.jhony.market.persistence.mapper;

import com.jhony.market.domain.Category;
import com.jhony.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
             @Mapping(source = "idCategoria", target = "categoryId"),
             @Mapping(source = "descripcion", target = "category"),
             @Mapping(source = "estado", target = "active")
    })
    Category toCateogry(Categoria categoria);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}
