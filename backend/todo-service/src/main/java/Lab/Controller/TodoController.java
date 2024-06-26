package Lab.Controller;

import Lab.Tools.Responses;
import Lab.data.dto.TodoDTO;
import Lab.Service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity getAllTodos() {
        try {
            List<TodoDTO> todoDTOList = todoService.getAll();
            return Responses.okResponse(todoDTOList);
        } catch (Exception e) {
            e.printStackTrace();
            return Responses.badResponse(e);
        }
    }

    @PostMapping
    public ResponseEntity createTodo(@Validated @RequestBody TodoDTO todoDTO) {
        try {
            todoService.save(todoDTO);
            return Responses.successResponse();
        } catch (Exception e) {
            e.printStackTrace();
            return Responses.badResponse(e);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable int id, @Validated @RequestBody TodoDTO todoDTO) {
        try {
            todoService.getTodoById(id);
            todoService.updateTodo(todoDTO, id);
            return Lab.Tools.Responses.successResponse();
        } catch (Exception e) {
            e.printStackTrace();
            return Lab.Tools.Responses.badResponse(e);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteTodo(HttpServletRequest request, @PathVariable int id) {
        try {
            todoService.deleteById(id);
            return Responses.successResponse();
        } catch (Exception e) {
            e.printStackTrace();
            return Responses.badResponse(e);
        }
    }
}
