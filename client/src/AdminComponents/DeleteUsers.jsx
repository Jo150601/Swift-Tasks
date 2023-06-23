import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const DeleteUsers = () => {
  const [user_id, setUser_Id] = useState('');
  const [successMessage, setSuccessMessage] = useState('');
  const [errorMessage, setErrorMessage] = useState('');
  const navigate = useNavigate();

  const handleDelete = (e) => {
    e.preventDefault();

    fetch(`http://localhost:8080/admin/deleteUser/${user_id}`, {
      method: 'DELETE',
    })
      .then((response) => {
        if (response.ok) {
          setSuccessMessage('User deleted successfully');
          setErrorMessage('');
          setUser_Id('');
          navigate('/viewallusers');
        } else {
          setSuccessMessage('');
          setErrorMessage('Failed to delete user!');
        }
      })
      .catch((error) => {
        console.error('Error:', error);
        setSuccessMessage('');
        setErrorMessage('An error occurred while deleting the employee');
      });
  };

  const back = () => {
    navigate('/Services');
  };

  return (
    <div className="ad-container">
      <h2>Delete Users</h2>
      <form>
        <div className="ad-form-group">
          <label>User ID:</label>
          <input
            type="text"
            placeholder="Enter User ID"
            className='ad-form-control'
            value={user_id}
            onChange={(e) => setUser_Id(e.target.value)}
          />
        </div>
        <div>
          <button className="ad-btn-danger" onClick={(e) => handleDelete(e)} style={{ marginRight: '10px' }}>Delete Users</button>

          <button className="ad-btn-success" onClick={back}>Back </button> 
        </div>
        {successMessage && <p>{successMessage}</p>}
        {errorMessage && <p>{errorMessage}</p>}
      </form>
    </div>
  );
};

export default DeleteUsers;