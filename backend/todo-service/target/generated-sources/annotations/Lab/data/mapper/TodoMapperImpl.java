package Lab.data.mapper;

import Lab.data.Todo;
import Lab.data.dto.TodoDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-26T19:24:18+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
public class TodoMapperImpl implements TodoMapper {

    @Override
    public TodoDTO todoToTodoDTO(Todo todo) {
        if ( todo == null ) {
            return null;
        }

        TodoDTO todoDTO = new TodoDTO();

        todoDTO.setId( todo.getId() );
        todoDTO.setTodo( todo.getTodo() );
        todoDTO.setPriority( String.valueOf( todo.getPriority() ) );

        return todoDTO;
    }

    @Override
    public Todo todoDTOToTodo(TodoDTO todoDTO) {
        if ( todoDTO == null ) {
            return null;
        }

        Todo todo = new Todo();

        todo.setId( todoDTO.getId() );
        todo.setTodo( todoDTO.getTodo() );
        if ( todoDTO.getPriority() != null ) {
            todo.setPriority( Integer.parseInt( todoDTO.getPriority() ) );
        }

        return todo;
    }
}
