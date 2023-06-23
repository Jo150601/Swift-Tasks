import React, { useState, useEffect } from 'react';
import axios from 'axios';

const TasksSortedByDueDate = () => {
  const [userId, setUserId] = useState('');
  const [sortedTasks, setSortedTasks] = useState([]);

  const handleInputChange = (event) => {
    setUserId(event.target.value);
  };

  const fetchTasksSortedByDueDate = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/user/gettasksortedbyduedate/${userId}`);
      const tasks = response.data;
      setSortedTasks(tasks);
    } catch (error) {
      console.error(error);
      setSortedTasks([]);
    }
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    fetchTasksSortedByDueDate();
  };

  return (
    <div className="tasks-sorted-by-due-date-container">
      <h2>Tasks Sorted by Due Date</h2>
      <form onSubmit={handleSubmit}>
        <label>User ID:</label>
        <input type="text" value={userId} onChange={handleInputChange} placeholder="Enter user ID" />
        <button type="submit">Fetch Sorted Tasks</button>
      </form>
      {sortedTasks.length > 0 ? (
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
            {sortedTasks.map((task) => (
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
        <p>No tasks found</p>
      )}
    </div>
  );
};

export default TasksSortedByDueDate;
