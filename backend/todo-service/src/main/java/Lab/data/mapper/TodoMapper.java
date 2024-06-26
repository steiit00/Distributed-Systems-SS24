package Lab.data.mapper;

import Lab.data.Todo;
import Lab.data.dto.TodoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TodoMapper {

    TodoMapper INSTANCE = Mappers.getMapper(TodoMapper.class);

    TodoDTO todoToTodoDTO(Todo todo);

    Todo todoDTOToTodo(TodoDTO todoDTO);
}
