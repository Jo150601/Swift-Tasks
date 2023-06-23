import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const AddUsers = () => {
  const [userId, setUserId] = useState('');
  const [userEmail, setUserEmail] = useState('');
  const [userName, setUserName] = useState('');
  const [userPhone, setUserPhone] = useState('');
  const [errorMessage, setErrorMessage] = useState('');
  const navigate = useNavigate();

  const changeUserIdHandler = (event) => {
    setUserId(event.target.value);
  };

  const changeUserEmailHandler = (event) => {
    setUserEmail(event.target.value);
  };

  const changeUserNameHandler = (event) => {
    setUserName(event.target.value);
  };

  const changeUserPhoneHandler = (event) => {
    setUserPhone(event.target.value);
  };

  const cancel = () => {
    navigate('/viewallusers');
  };

  const validateFields = () => {
    if (!userId || !userEmail || !userName || !userPhone) {
      setErrorMessage('All fields are mandatory');
      return false;
    }

    if (userId < 0) {
      setErrorMessage('User ID cannot be negative');
      return false;
    }

    if (!userEmail.endsWith('@gmail.com')) {
      setErrorMessage('Email should end with @gmail.com');
      return false;
    }

    if (userPhone.length !== 10 || !/^\d+$/.test(userPhone)) {
      setErrorMessage('Phone number should be 10 digits');
      return false;
    }

    setErrorMessage('');
    return true;
  };

  const saveUser = async (e) => {
    e.preventDefault();

    if (validateFields()) {
      let user = {
        user_id: userId,
        user_email: userEmail,
        user_name: userName,
        user_phoneno: userPhone,
      };

      try {
        await axios.post('http://localhost:8080/admin/addUser', user);
        console.log('User added successfully:', user);
        navigate('/viewallusers');
      } catch (error) {
        console.error('Error adding user:', error);
      }
    }
  };

  return (
    <div>
      <br />
      <div className="ad-container">
        <div className="row">
          <div className="custom-card">
            <h2 className="text-ad">Add Users</h2>
            <div className="ad-card-body">
              <form>
                {errorMessage && <div className="error-message">{errorMessage}</div>}

                <div className="ad-form-group">
                  <label className="ad-form-label">Enter User ID:</label>
                  <input
                    placeholder="User ID"
                    name="userId"
                    className="form-control"
                    value={userId}
                    onChange={changeUserIdHandler}
                  />
                </div>

                <div className="ad-form-group">
                  <label className="ad-form-label">Enter User Name:</label>
                  <input
                    placeholder="User Name"
                    name="userName"
                    className="form-control"
                    value={userName}
                    onChange={changeUserNameHandler}
                  />
                </div>

                <div className="ad-form-group">
                  <label className="ad-form-label">Enter User Email:</label>
                  <input
                    placeholder="User Email"
                    name="userEmail"
                    className="form-control"
                    value={userEmail}
                    onChange={changeUserEmailHandler}
                  />
                </div>

                <div className="ad-form-group">
                  <label className="ad-form-label">Enter User Phone Number:</label>
                  <input
                    placeholder="User Phone Number"
                    name="userPhone"
                    className="form-control"
                    value={userPhone}
                    onChange={changeUserPhoneHandler}
                  />
                </div>

                <button className="ad-btn-success " onClick={saveUser}>
                  Save
                </button>
                <button className="ad-btn-danger" onClick={cancel} style={{ marginLeft: '10px' }}>
                  Cancel
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AddUsers;
