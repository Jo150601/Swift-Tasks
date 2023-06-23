import React, { useEffect, useState } from 'react';

const TaskList = () => {
  const [tasks, setTasks] = useState([]);
  const [user_id, setUser_Id] = useState('');

  const fetchTasks = async () => {
    try {
      const response = await fetch(`http://localhost:8080/user/alltasks/${user_id}`);
      if (response.ok) {
        const data = await response.json();
        setTasks(data);
      }
    } catch (error) {
      console.error('Error fetching tasks:', error);
    }
  };

  const handleViewTasks = () => {
    if (user_id) {
      fetchTasks();
    }
  };

  return (
    <div style={{ backgroundColor: '#f2f2f2', padding: '20px', borderRadius: '5px' }}>
      <h2 style={{ marginBottom: '10px' }}>View Tasks</h2>
      <div style={{ marginBottom: '10px' }}>
        <label style={{ marginRight: '10px' }}>User ID:</label>
        <input
          type="text"
          value={user_id}
          onChange={(event) => setUser_Id(event.target.value)}
          style={{ padding: '5px' }}
          placeholder="Enter user ID"
        />
      </div>
      <button
        onClick={handleViewTasks}
        style={{ padding: '10px 20px', backgroundColor: '#007bff', color: '#fff', borderRadius: '5px', border: 'none' }}
      >
        View Tasks
      </button>
      {tasks.length === 0 ? (
        <p style={{ marginTop: '10px' }}>No tasks found.</p>
      ) : (
        <ul style={{ marginTop: '10px' }}>
          {tasks.map((task) => (
            <li key={task.task_id} style={{ marginBottom: '5px' }}>
              {task.task_name} - Start Date: {task.task_start_date}, End Date: {task.task_end_date}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default TaskList;
