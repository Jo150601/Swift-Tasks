import React, { useState } from 'react';

function AddTasks() {
  const [tasks, setTasks] = useState([]);
  const [user_id, setUser_Id] = useState('');
  const [newTask, setNewTask] = useState({
    title: '',
    startDate: '',
    endDate: '',
    isDone: false,
    category: '',
  });

  const handleUserIdChange = (event) => {
    setUser_Id(event.target.value);
  };

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setNewTask((prevTask) => ({ ...prevTask, [name]: value }));
  };

  const handleAddTask = async () => {
    try {
      const response = await fetch('http://localhost:8080/user/addtask', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          task_name: newTask.title,
          task_start_date: newTask.startDate,
          task_end_date: newTask.endDate,
          task_category: newTask.category,
          isdone: newTask.isDone,
          user_id: { user_id },
        }),
      });
      if (response.ok) {
        const data = await response.json();
        setTasks((prevTasks) => [...prevTasks, data]);
        setNewTask({
          title: '',
          startDate: '',
          endDate: '',
          isDone: false,
          category: '',
        });
      }
    } catch (error) {
      console.error('Error adding task:', error);
    }
  };

  const fetchTasks = async () => {
    try {
      const response = await fetch(`http://localhost:8080/user/alltasks/${user_id}`);
      if (response.ok) {
        const data = await response.json();
        setTasks(data);
      } else {
        setTasks([]);
      }
    } catch (error) {
      console.error('Error fetching tasks:', error);
    }
  };

  const handleButtonClick = () => {
    if (user_id) {
      fetchTasks();
    }
  };

  return (
    <div className="container" style={{ backgroundColor: '#f2f2f2', padding: '20px', borderRadius: '5px' }}>
      <div className="row">
        <div className="col-md-6">
          <h1>Add Task</h1>
          <div className="form-group">
            <label htmlFor="userId">User ID:</label>
            <input
              type="text"
              id="userId"
              className="form-control"
              value={user_id}
              onChange={handleUserIdChange}
              placeholder="Enter user ID"
            />
          </div>
          <div className="form-group">
            <label htmlFor="title">Title:</label>
            <input
              type="text"
              id="title"
              name="title"
              className="form-control"
              value={newTask.title}
              onChange={handleInputChange}
            />
          </div>
          <div className="form-group">
            <label htmlFor="startDate">Start Date:</label>
            <input
              type="date"
              id="startDate"
              name="startDate"
              className="form-control"
              value={newTask.startDate}
              onChange={handleInputChange}
            />
          </div>
          <div className="form-group">
            <label htmlFor="endDate">End Date:</label>
            <input
              type="date"
              id="endDate"
              name="endDate"
              className="form-control"
              value={newTask.endDate}
              onChange={handleInputChange}
            />
          </div>
          <div className="form-group">
            <label htmlFor="isDone">Is Done:</label>
            <input
              type="checkbox"
              id="isDone"
              name="isDone"
              checked={newTask.isDone}
              onChange={(e) =>
                setNewTask((prevTask) => ({ ...prevTask, isDone: e.target.checked }))
              }
            />
          </div>
          <div className="form-group">
            <label htmlFor="category">Category:</label>
            <input
              type="text"
              id="category"
              name="category"
              className="form-control"
              value={newTask.category}
              onChange={handleInputChange}
            />
          </div>
          <button onClick={handleAddTask} className="btn btn-primary">Add Task</button>
          <button onClick={handleButtonClick} className="btn btn-primary">Fetch Tasks</button>
          <h2>All Tasks:</h2>
          {tasks.length === 0 ? (
            <p>No tasks found</p>
          ) : (
            <ul>
              {tasks.map((task) => (
                <li key={task.task_id}>
                  {task.task_name} - {task.task_start_date} to {task.task_end_date} -{' '}
                  {task.isdone ? 'Done' : 'Not Done'} - {task.task_category}
                </li>
              ))}
            </ul>
          )}
        </div>
      </div>
    </div>
  );
}

export default AddTasks;
