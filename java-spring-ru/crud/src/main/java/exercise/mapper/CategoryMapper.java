package exercise.mapper;

import exercise.dto.CategoryCreateDTO;
import exercise.dto.CategoryDTO;
import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductDTO;
import exercise.model.Category;
import exercise.model.Product;
import net.datafaker.providers.base.Cat;
import org.mapstruct.*;

// BEGIN
@Mapper(
        uses = { JsonNullableMapper.class, ReferenceMapper.class },
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class CategoryMapper {

    public abstract Category map(CategoryCreateDTO dto);

    public abstract CategoryDTO map(Category model);
}
// END
