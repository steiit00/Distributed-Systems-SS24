package Lab.Service;

import Lab.data.Todo;
import Lab.data.dto.TodoDTO;
import Lab.data.mapper.TodoMapper;
import Lab.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<TodoDTO> getAll() {
        var todoList = todoRepository.findAll();
        var todoDTOList = todoList.stream().map(u -> TodoMapper.INSTANCE.todoToTodoDTO(u)).collect(toList());
        return todoDTOList;
    }

    @Override
    public TodoDTO getTodoById(int id) {
        var todo = todoRepository.findById(id).orElse(null);
        return (todo != null) ? TodoMapper.INSTANCE.todoToTodoDTO(todo) : null;
    }

    @Override
    public void save(TodoDTO todoDTO) {
        var todo = TodoMapper.INSTANCE.todoDTOToTodo(todoDTO);
        todoRepository.save(todo);
    }

    @Override
    public void updateTodo(TodoDTO todoDTO, int id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (!optionalTodo.isEmpty()) {
            Todo todo = TodoMapper.INSTANCE.todoDTOToTodo(todoDTO);
            todo.setId(id);
            todoRepository.save(todo);
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteById(int id) {
        todoRepository.deleteById(id);
    }
}
