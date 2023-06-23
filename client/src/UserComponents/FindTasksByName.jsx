import React, { useState } from 'react';
import axios from 'axios';

const FindTasksByName = () => {
  const [task_name, setTask_Name] = useState('');
  const [foundTasks, setFoundTasks] = useState(null);

  const handleSearch = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/user/findtasksbyname/${task_name}`);
      const tasks = response.data;
      setFoundTasks(tasks);
    } catch (error) {
      console.error(error);
      setFoundTasks(null);
    }
  };

  return (
    <div className="task-search-container">
      <input
        type="text"
        value={task_name}
        onChange={(e) => setTask_Name(e.target.value)}
        placeholder="Enter task name"
      />
      <button className="search-button" onClick={handleSearch}>
        Search
      </button>
      <br />
      {foundTasks ? (
        <table className="table-striped">
          <thead>
            <tr>
              <th>Task ID</th>
              <th>Task Name</th>
              <th>Task Start Date</th>
              <th>Task End Date</th>
              <th>Task Category</th>
              <th>Is Done</th>
            </tr>
          </thead>
          <tbody>
            {foundTasks.map((task) => (
              <tr key={task.task_id}>
                <td>{task.task_id}</td>
                <td>{task.task_name}</td>
                <td>{task.task_start_date}</td>
                <td>{task.task_end_date}</td>
                <td>{task.task_category}</td>
                <td>{task.isdone ? 'Yes' : 'No'}</td>
              </tr>
            ))}
          </tbody>
        </table>
      ) : (
        <p className="no-task">No task found</p>
      )}
    </div>
  );
};

export default FindTasksByName;
