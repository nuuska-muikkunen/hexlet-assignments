package exercise.mapper;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.model.Book;
import org.mapstruct.*;

@Mapper(
        uses = {JsonNullableMapper.class, ReferenceMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class BookMapper {

    // BEGIN
    @Mapping(target = "authorId", source = "author.id")
    @Mapping(target = "authorFirstName", source = "author.firstName")
    @Mapping(target = "authorLastName", source = "author.lastName")
    public abstract BookDTO map(Book book);

    @Mapping(target = "author", source = "authorId")
    public abstract Book map(BookDTO book);

    @Mapping(target = "author", source = "authorId")
    public abstract Book map(BookCreateDTO book);
    // END

    @Mapping(target = "author", source = "authorId")
    public abstract void update(BookUpdateDTO dto, @MappingTarget Book model);
}
