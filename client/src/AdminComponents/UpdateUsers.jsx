import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate, useParams } from 'react-router-dom';

const UpdateUsers = () => {
  const [userId, setUserId] = useState('');
  const [userEmail, setUserEmail] = useState('');
  const [userName, setUserName] = useState('');
  const [userPhone, setUserPhone] = useState('');
  const navigate = useNavigate();

  const { id } = useParams();

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/admin/getUserById/${id}`);
        const user = response.data;
        setUserEmail(user.user_email);
        setUserName(user.user_name);
        setUserPhone(user.user_phoneno);
      } catch (error) {
        console.error('Error fetching user:', error);
      }
    };

    fetchData();
  }, [id]);

  const updateUser = async (e) => {
    e.preventDefault();

    try {
      await axios.post(`http://localhost:8080/admin/updateUser/${id}`, {
        user_id: userId,
        user_email: userEmail,
        user_name: userName,
        user_phoneno: userPhone,
      });
      console.log('User updated successfully:', { userId, userEmail, userName, userPhone });
      navigate('/viewallusers');
    } catch (error) {
      console.error('Error updating user:', error);
      console.log('AxiosError:', error.response); // Log the AxiosError object
    }
  };

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

  return (
    <div className="custom-card">
      <h2 className='text-word'>Update User Details</h2>
      <br />
      <div className="container">
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3">
            <div className="card-body">
              <form>
                <div className="ad-form-groupp">
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

                <div className="ad-form-groupp">
                  <label className="ad-form-label">Enter User Email:</label>
                  <input
                    placeholder="User Email"
                    name="userEmail"
                    className="form-control"
                    value={userEmail}
                    onChange={changeUserEmailHandler}
                  />
                </div>

                <div className="ad-form-groupp">
                  <label className="ad-form-label">Enter User Phone Number:</label>
                  <input
                    placeholder="User Phone Number"
                    name="userPhone"
                    className="form-control"
                    value={userPhone}
                    onChange={changeUserPhoneHandler}
                  />
                </div>

                <button className="ad-btn-success" onClick={updateUser}>
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

export default UpdateUsers;

