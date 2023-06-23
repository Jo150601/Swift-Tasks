import React, { useState, useEffect } from 'react';
import axios from 'axios';

const FinishedTasks = () => {
  const [userId, setUserId] = useState('');
  const [finishedTasks, setFinishedTasks] = useState([]);

  const handleInputChange = (event) => {
    setUserId(event.target.value);
  };

  const fetchFinishedTasks = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/user/getfinishedtasks/${userId}`);
      const tasks = response.data;
      setFinishedTasks(tasks);
    } catch (error) {
      console.error(error);
      setFinishedTasks([]);
    }
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    fetchFinishedTasks();
  };

  return (
    <div className="finished-tasks-container">
      <h2>Finished Tasks</h2>
      <form onSubmit={handleSubmit}>
        <label>User ID:</label>
        <input type="text" value={userId} onChange={handleInputChange} placeholder="Enter user ID" />
        <button type="submit">Fetch Finished Tasks</button>
      </form>
      {finishedTasks.length > 0 ? (
        <table className="table-striped">
          <thead>
            <tr>
              <th>Task ID</th>
              <th>Task Name</th>
              <th>Task Start Date</th>
              <th>Task End Date</th>
              <th>Task Category</th>
            </tr>
          </thead>
          <tbody>
            {finishedTasks.map((task) => (
              <tr key={task.task_id}>
                <td>{task.task_id}</td>
                <td>{task.task_name}</td>
                <td>{task.task_start_date}</td>
                <td>{task.task_end_date}</td>
                <td>{task.task_category}</td>
              </tr>
            ))}
          </tbody>
        </table>
      ) : (
        <p>No finished tasks found</p>
      )}
    </div>
  );
};

export default FinishedTasks;
