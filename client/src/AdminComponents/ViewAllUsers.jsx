import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';


const ViewAllUsers = () => {
  const [users, setUsers] = useState([]);
  const navigate = useNavigate();

  const loadUsers = async () => {
    try {
      const response = await axios.get('http://localhost:8080/admin/viewallusers');
      setUsers(response.data);
    } catch (error) {
      console.error('Error fetching users:', error);
    }
  };

  const addUsers = () => {
    navigate('/addUser');
  };

  const editUser = (user_id) => {
    navigate(`/updateUser/${user_id}`);
  };

  useEffect(() => {
    loadUsers();
  }, []);

  const deleteUsers = (user_id) => {
    const confirmation = window.confirm('Would you like to delete?');
    if (confirmation) {
      axios
        .delete(`http://localhost:8080/admin/deleteUser/${user_id}`)
        .then((response) => {
          setUsers(users.filter((user) => user.user_id !== user_id));
        })
        .catch((error) => {
          console.log(error);
        });
    }
  };
  
  

  return (
    <div>
      <h2 className="text-center">List of Users</h2>
      <div className="btn btn-info" onClick={addUsers} style={{ marginBottom: '10px' }}>
        Add Users
      </div>
      <div className="row">
        <table className="table table-striped table-bordered">
          <thead>
            <tr>
              <th>User ID</th>
              <th>User's Email ID</th>
              <th>User's Name</th>
              <th>User's Phone Number</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {users.map((user) => (
              <tr key={user.user_id}>
                <td>{user.user_id}</td>
                <td>{user.user_email}</td>
                <td>{user.user_name}</td>
                <td>{user.user_phoneno}</td>
                <td>
                  <button onClick={() => editUser(user.user_id)} className="ad-btn-success">
                    Update
                  </button>
                  <button className="ad-btn-danger" onClick={() => deleteUsers(user.user_id)} style={{ marginLeft: '10px' }}>
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default ViewAllUsers;

