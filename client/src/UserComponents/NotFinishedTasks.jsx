import React, { useState, useEffect } from 'react';
import axios from 'axios';

const NotFinishedTasks = () => {
  const [user_id, setUserId] = useState('');
  const [notFinishedTasks, setNotFinishedTasks] = useState([]);

  useEffect(() => {
    if (user_id) {
      const fetchNotFinishedTasks = async () => {
        try {
          const response = await axios.get(`http://localhost:8080/user/getnotfinishedtasks/${user_id}`);
          const tasks = response.data;
          setNotFinishedTasks(tasks);
        } catch (error) {
          console.error(error);
          setNotFinishedTasks([]);
        }
      };

      fetchNotFinishedTasks();
    }
  }, [user_id]);

  const handleUserIdChange = (event) => {
    setUserId(event.target.value);
  };

  return (
    <div className="not-finished-tasks-container">
      <h2>Not Finished Tasks</h2>
      <div>
        <label htmlFor="user_id">User ID:</label>
        <input
          type="text"
          id="user_id"
          name="user_id"
          value={user_id}
          onChange={handleUserIdChange}
        />
      </div>
      {notFinishedTasks.length > 0 ? (
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
            {notFinishedTasks.map((task) => (
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
        <p>No not finished tasks found</p>
      )}
    </div>
  );
};

export default NotFinishedTasks;
