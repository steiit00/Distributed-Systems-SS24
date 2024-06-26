package Lab.Service;

import Lab.data.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    List<TodoDTO> getAll();

    TodoDTO getTodoById(int id);

    void save(TodoDTO todoDTO);

    void updateTodo(TodoDTO todoDTO, int id);

    void deleteById(int id);

}
