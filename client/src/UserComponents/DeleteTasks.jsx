import React, { useState } from 'react';

const DeleteTasks = () => {
  const [taskId, setTaskId] = useState('');

  const handleDelete = async () => {
    try {
      await fetch(`http://localhost:8080/user/deleteTask/${taskId}`, {
        method: 'DELETE'
      });
      console.log(`Task with ID ${taskId} deleted successfully.`);
    } catch (error) {
      console.error('Error deleting task:', error);
    }
  };

  const handleInputChange = (event) => {
    setTaskId(event.target.value);
  };

  return (
    <div style={{ backgroundColor: '#f2f2f2', padding: '20px', borderRadius: '5px' }}>
      <label style={{ marginRight: '10px' }}>Task ID:</label>
      <input
        type="text"
        value={taskId}
        onChange={handleInputChange}
        style={{ padding: '5px' }}
        placeholder="Enter task ID"
      />
      <button
        onClick={handleDelete}
        style={{ padding: '10px 20px', backgroundColor: '#dc3545', color: '#fff', borderRadius: '5px', border: 'none' }}
      >
        Delete Task
      </button>
    </div>
  );
};

export default DeleteTasks;
