import React, { useState, useEffect } from 'react';
import axios from 'axios';
import 'primereact/resources/themes/saga-blue/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';
import { Dialog } from 'primereact/dialog';
import { InputText } from 'primereact/inputtext';
import { Button } from 'primereact/button';

const TodoApp = () => {
  const [todos, setTodos] = useState([]);
  const [visible, setVisible] = useState(false);
  const [updateVisible, setUpdateVisible] = useState(false);
  const [newTodo, setNewTodo] = useState({ id: 0, todo: '', priority: 1 });
  const [currentTodoId, setCurrentTodoId] = useState(null);
  const [error, setError] = useState('');

  useEffect(() => {
    fetchTodos();
  }, []);

  const fetchTodos = async () => {
    try {
      const response = await axios.get('http://localhost:8001/todo');
      setTodos(response.data);
    } catch (error) {
      console.error('Error fetching todos:', error);
    }
  };

  const addTodo = async () => {
    if (validateInput(newTodo.priority)) {
      try {
        await axios.post('http://localhost:8001/todo', newTodo);
        setNewTodo({ id: 0, todo: '', priority: 1 });
        setVisible(false);
        setError('');
        fetchTodos();
      } catch (error) {
        console.error('Error adding todo:', error);
      }
    } else {
      setError('Priority must be a number');
    }
  };

  const openUpdateDialog = (todo) => {
    setCurrentTodoId(todo.id);
    setNewTodo({ id: todo.id, todo: todo.todo, priority: todo.priority });
    setUpdateVisible(true);
  };

  const updateTodo = async () => {
    if (validateInput(newTodo.priority)) {
      try {
        await axios.put(`http://localhost:8001/todo/${currentTodoId}`, {
          todo: newTodo.todo,
          priority: newTodo.priority,
        });
        fetchTodos();
        setNewTodo({ id: 0, todo: '', priority: 1 });
        setUpdateVisible(false);
        setError('');
      } catch (error) {
        console.error('Error updating todo:', error);
      }
    } else {
      setError('Priority must be a number');
    }
  };

  const deleteTodo = async (id) => {
    try {
      await axios.delete(`http://localhost:8001/todo/${id}`);
      fetchTodos();
    } catch (error) {
      console.error('Error deleting todo:', error);
    }
  };

  const validateInput = (value) => {
    return !isNaN(value) && value !== null && value !== '';
  };

  const getPriorityColor = (priority) => {
    if (priority < 4) return 'lightcoral';
    if (priority >= 4 && priority < 7) return 'lightyellow';
    return 'lightgreen';
  };

  const sortedTodos = todos.sort((a, b) => a.priority - b.priority);

  return (
    <div className="App">
      <div className="title">Todo Liste</div>
      <div className="legend">
        <span className="legend-item red">Priorität &lt;= 3</span>
        <span className="legend-item yellow">Priorität 4 - 6</span>
        <span className="legend-item green">Priorität &gt;= 7</span>
      </div>
      <div className="todoList">
        <Button onClick={() => setVisible(true)} label="Todo hinzufügen" className="p-button-raised createTodo" />
        <Dialog header="Neues Todo anlegen" visible={visible} style={{ width: '50vw' }} onHide={() => setVisible(false)}>
          <InputText value={newTodo.todo} onChange={(e) => setNewTodo({ ...newTodo, todo: e.target.value })} placeholder="Name" className="input" />
          <InputText value={newTodo.priority} onChange={(e) => setNewTodo({ ...newTodo, priority: parseInt(e.target.value) || '' })} placeholder="Priorität" className="input" />
          <Button onClick={addTodo} label="Bestätigen" />
          {error && <div className="error">{error}</div>}
        </Dialog>
        <div className="todoContainer">
  {sortedTodos.map((entry) => (
    <div key={entry.id} className="todoBox" style={{ backgroundColor: getPriorityColor(entry.priority) }}>
      <div className="todoItems">
        <div>
          <div className="todoItem">{entry.todo}</div>
        </div>
        <div className="buttonContainer">
          <Button icon="pi pi-pencil" className="p-button-rounded p-button-info icons" onClick={() => openUpdateDialog(entry)} />
          <Button icon="pi pi-trash" className="p-button-rounded p-button-danger icons" onClick={() => deleteTodo(entry.id)} />
        </div>
      </div>
    </div>
  ))}
</div>

        <Dialog header="Todo bearbeiten" visible={updateVisible} style={{ width: '50vw' }} onHide={() => setUpdateVisible(false)}>
          <InputText value={newTodo.todo} onChange={(e) => setNewTodo({ ...newTodo, todo: e.target.value })} placeholder="Name" className="input" />
          <InputText value={newTodo.priority} onChange={(e) => setNewTodo({ ...newTodo, priority: parseInt(e.target.value) || '' })} placeholder="Priorität" className="input" />
          <Button onClick={updateTodo} label="Bestätigen" />
          {error && <div className="error">{error}</div>}
        </Dialog>
      </div>
    </div>
  );
};

export default TodoApp;
