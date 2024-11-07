package net.javaguides.expense.mapper;

import net.javaguides.expense.dto.CategoryDto;
import net.javaguides.expense.entity.Category;

public class CategoryMapper {

    //map categorydto to category entity
     public static Category mapToCategory(CategoryDto categoryDto){
         return new Category(
                 categoryDto.id(), categoryDto.name()
         );
     }

    //map category entity to categorydto
    public static CategoryDto mapToCategoryDto(Category category){
        return new CategoryDto(
                category.getId(), category.getName()
        );
    }

}
