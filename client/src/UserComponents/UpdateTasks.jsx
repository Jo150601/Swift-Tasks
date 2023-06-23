import React, { useState } from 'react';
import axios from 'axios';

const UpdateTask = () => {
  const [taskId, setTaskId] = useState('');
  const [updatedTask, setUpdatedTask] = useState({
    task_name: '',
    task_start_date: '',
    task_end_date: '',
    task_category: '',
    isdone: false,
  });

  const handleTaskIdChange = (event) => {
    setTaskId(event.target.value);
  };

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setUpdatedTask((prevTask) => ({ ...prevTask, [name]: value }));
  };

  const handleUpdateTask = async () => {
    try {
      const response = await axios.put(`http://localhost:8080/user/updatetasks/${taskId}`, updatedTask);
      if (response.status === 200) {
        console.log('Task updated successfully:', response.data);
        // Perform any additional actions after task update
      }
    } catch (error) {
      console.error('Error updating task:', error);
    }
  };

  return (
    <div style={{ backgroundColor: '#f2f2f2', padding: '20px', borderRadius: '5px' }}>
      <h1>Update Task</h1>
      <div>
        <label style={{ marginRight: '10px' }}>Task ID:</label>
        <input type="text" value={taskId} onChange={handleTaskIdChange} style={{ padding: '5px' }} placeholder="Enter task ID" />
      </div>
      <div>
        <label style={{ marginRight: '10px' }}>Task Name:</label>
        <input type="text" name="task_name" value={updatedTask.task_name} onChange={handleInputChange} style={{ padding: '5px' }} />
      </div>
      <div>
        <label style={{ marginRight: '10px' }}>Start Date:</label>
        <input type="date" name="task_start_date" value={updatedTask.task_start_date} onChange={handleInputChange} style={{ padding: '5px' }} />
      </div>
      <div>
        <label style={{ marginRight: '10px' }}>End Date:</label>
        <input type="date" name="task_end_date" value={updatedTask.task_end_date} onChange={handleInputChange} style={{ padding: '5px' }} />
      </div>
      <div>
        <label style={{ marginRight: '10px' }}>Category:</label>
        <input type="text" name="task_category" value={updatedTask.task_category} onChange={handleInputChange} style={{ padding: '5px' }} />
      </div>
      <div>
        <label style={{ marginRight: '10px' }}>Is Done:</label>
        <input
          type="checkbox"
          name="isdone"
          checked={updatedTask.isdone}
          onChange={(e) => setUpdatedTask((prevTask) => ({ ...prevTask, isdone: e.target.checked }))}
        />
      </div>
      <button
        onClick={handleUpdateTask}
        style={{
          padding: '10px 20px',
          backgroundColor: '#007bff',
          color: '#fff',
          borderRadius: '5px',
          border: 'none',
          cursor: 'pointer',
        }}
      >
        Update Task
      </button>
    </div>
  );
};

export default UpdateTask;
