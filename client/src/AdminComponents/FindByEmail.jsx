import React, { useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

const FindByEmail = () => {
  const [user_email, setEmail] = useState('');
  const [foundUsers, setFoundUsers] = useState(null);

  const handleSearch = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/admin/getUserByEmail/${user_email}`);
      const users = response.data;
      setFoundUsers(users);
    } catch (error) {
      console.error(error);
      setFoundUsers(null);
    }
  };

  return (
    <div className="user-search-container">
      <input
        type="text"
        value={user_email}
        onChange={(e) => setEmail(e.target.value)}
        placeholder="Enter email"
      />
      <button className="search-button" onClick={handleSearch} style={{ marginBottom: '10px' }}>
        Search
      </button>
      <Link to="/services">
        <button className="return-button">Return</button>
      </Link>
      <br />
      {foundUsers ? (
        <table className="table-striped">
          <thead>
            <tr>
              <th>User Id</th>
              <th>User Name</th>
              <th>User PhoneNo</th>
              <th>User Email</th>
            </tr>
          </thead>
          <tbody>
            {foundUsers.map((user) => (
              <tr key={user.user_id}>
                <td>{user.user_id}</td>
                <td>{user.user_name}</td>
                <td>{user.user_phoneno}</td>
                <td>{user.user_email}</td>
              </tr>
            ))}
          </tbody>
        </table>
      ) : (
        <p className="no-user">No user found</p>
      )}
    </div>
  );
};

export default FindByEmail;
