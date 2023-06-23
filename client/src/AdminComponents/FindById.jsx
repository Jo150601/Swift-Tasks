import React, { useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

const FindById = () => {
    const [user_id, setUser_Id] = useState('');
    const [foundusers, setFoundUsers] = useState(null);
  
    const handleSearch = async () => {
        try {
          const response = await axios.get(`http://localhost:8080/admin/getUserById/${user_id}`);
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
          value={user_id}
          onChange={(e) => setUser_Id(e.target.value)}
          placeholder="Enter user ID"
        />
        <button className="search-button" onClick={handleSearch} style={{ marginBottom: '10px' }}>Search</button>
        <Link to = "/services"><button className='return-button'> Return </button></Link>
        <br/>
        {foundusers ? (
            <table className="table-striped">
                <thead>
                    <th> User Id </th>
                    <th> User Name </th>
                    <th> User PhoneNo</th>
                    <th> User Email </th>
                </thead>
                <tbody>
                            <tr key = {foundusers.user_id}> 
                                <td> {foundusers.user_id} </td>
                                <td> {foundusers.user_name} </td>
                                <td>{foundusers.user_email}</td>
                                <td>{foundusers.user_phoneno}</td>
                            </tr>
                </tbody>
            </table>
        ) : (
          <p className='no-user'>No user found</p>
        )}
      </div>
    );
  }

export default FindById;