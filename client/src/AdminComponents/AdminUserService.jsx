import React from 'react';
import { Link } from 'react-router-dom';
import Card from 'react-bootstrap/Card';
import Button from 'react-bootstrap/Button';

const AdminUserServices = () => {
  return (
    <div className="backg">
      <div className="main-ad">
        <Card>
          <Card.Body>
            <Card.Title>Add Users</Card.Title>
            <Link to="/addUser" className="btn-emp">
              <Button className="btn-add">Add Users</Button>
            </Link>
          </Card.Body>
        </Card>

        <Card>
          <Card.Body>
            <Card.Title>View All Users</Card.Title>
            <Link to="/viewallusers" className="btn-emp">
              <Button className="btn-add">View All Users</Button>
            </Link>
          </Card.Body>
        </Card>

        <Card>
          <Card.Body>
            <Card.Title>Update User Details</Card.Title>
            <Link to="/updateUser" className="btn-emp">
              <Button className="btn-add">Update User Details</Button>
            </Link>
          </Card.Body>
        </Card>

        <Card>
          <Card.Body>
            <Card.Title>Delete Users</Card.Title>
            <Link to="/deleteUser" className="btn-emp">
              <Button className="btn-add">Delete Users</Button>
            </Link>
          </Card.Body>
        </Card>

        <Card>
          <Card.Body>
            <Card.Title>Find User By ID</Card.Title>
            <Link to="/getUserById" className="btn-emp">
              <Button className="btn-add">Find User By ID</Button>
            </Link>
          </Card.Body>
        </Card>

        <Card>
          <Card.Body>
            <Card.Title>Find User By Name</Card.Title>
            <Link to="/getUserByName" className="btn-emp">
              <Button className="btn-add">Find User By Name</Button>
            </Link>
          </Card.Body>
        </Card>

        <Card>
          <Card.Body>
            <Card.Title>Find User By Email</Card.Title>
            <Link to="/getUserByEmail" className="btn-emp">
              <Button className="btn-add">Find User By Email</Button>
            </Link>
          </Card.Body>
        </Card>

        <Card>
          <Card.Body>
            <Card.Title>Find User By Phone</Card.Title>
            <Link to="/getUserByPhoneNo" className="btn-emp">
              <Button className="btn-add">Find User By Phone</Button>
            </Link>
          </Card.Body>
        </Card>
      </div>
    </div>
  );
};

export default AdminUserServices;
