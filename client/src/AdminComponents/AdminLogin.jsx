import axios from 'axios';
import React, { useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';

const AdminLogin = () => {
  const navigate = useNavigate();
  const [admin_id, setAdmin_Id] = useState('');
  const [user_id, setUser_Id] = useState('');
  const [user_phoneno, setUser_Phoneno] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (admin_id === 'jo123' && password === '9841715549') {
      // Admin login
      const admindata = { admin_id, password };
      sessionStorage.setItem('loginDetails', JSON.stringify(admindata));
      navigate('/Admin/home');
    } else {
      try {
        // Check user_info table for credentials
        const response = await axios.get('http://localhost:8080/admin/viewallusers', { user_id, user_phoneno });
        const userData = response.data;

        if (userData) {
          sessionStorage.setItem('loginDetails', JSON.stringify(userData));
          navigate('/UserHome');
        } else {
          setError('Invalid credentials. Please try again.');
        }
      } catch (error) {
        setError('An error occurred during login. Please try again.');
      }
    }
  };

  return (
    <div className='container'>
      <div className='row justify-content-center'>
        <div className='col-lg-6'>
          <div className='card'>
            <div className='card-body'>
              <h2 className='card-title mb-4'>Login</h2>
              <form onSubmit={handleSubmit}>
                <div className='form-group'>
                  <label htmlFor='AdminId'>ID</label>
                  <input
                    type='text'
                    id='userId'
                    className='form-control'
                    placeholder='Enter ID'
                    value={admin_id}
                    onChange={(e) => setAdmin_Id(e.target.value)}
                    autoComplete='off'
                  />
                </div>
                <div className='form-group'>
                  <label htmlFor='password'>Password</label>
                  <input
                    type='password'
                    id='password'
                    className='form-control'
                    placeholder='Enter Password'
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                  />
                </div>
                <div className='d-flex justify-content-between align-items-center'>
                  <button type='submit' className='btn btn-primary'>
                    Log in
                  </button>
                </div>
                {error && <div className='text-danger mt-3'>{error}</div>}
                <p className='mt-3'>You agree to our terms and policies</p>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AdminLogin;

