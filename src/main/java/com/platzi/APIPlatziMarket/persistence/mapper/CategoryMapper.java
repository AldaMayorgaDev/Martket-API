package com.platzi.APIPlatziMarket.persistence.mapper;

import com.platzi.APIPlatziMarket.domain.Category;
import com.platzi.APIPlatziMarket.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    /*
    * Mapenado los valores entre persistencia y dominio con mapstruct
    *
    * la notacion @Mapping( {source = "Origen", target="destino"})
    * */
    @Mappings({
                    @Mapping(source = "idCategoria", target = "categoryId"),
                    @Mapping(source = "descripcion", target = "category"),
                    @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria categoria); //Retorna una Category con el nombre toCategory que recibe una categoria



    //@InheritInverseConfiguration indica que se hara el mapeo inversp a los valores de arriba
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true) //como en Categoria tenemos un atributo productos el cual no estara en el dominio, se añade un ignore= true al mapping
    Categoria toCategoria(Category category);
}
