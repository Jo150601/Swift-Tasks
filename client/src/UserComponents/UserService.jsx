import React from 'react';
import { Link } from 'react-router-dom';
import Card from 'react-bootstrap/Card';
import Button from 'react-bootstrap/Button';

const UserService = () => {
  return (
    <div className="backg">
      <div className="main-ad">
        <Card>
          <Card.Body>
            <Card.Title>Add Tasks</Card.Title>
            <Link to="/addtask" className="btn-emp">
              <Button className="btn-add">Add Tasks</Button>
            </Link>
          </Card.Body>
        </Card>

        <Card>
          <Card.Body>
            <Card.Title>View All Tasks</Card.Title>
            <Link to="/alltasks" className="btn-emp">
              <Button className="btn-add">View All Tasks</Button>
            </Link>
          </Card.Body>
        </Card>

        <Card>
          <Card.Body>
            <Card.Title>Update Tasks</Card.Title>
            <Link to="/updateTask" className="btn-emp">
              <Button className="btn-add">Update Tasks</Button>
            </Link>
          </Card.Body>
        </Card>

        <Card>
          <Card.Body>
            <Card.Title>Delete Tasks</Card.Title>
            <Link to="/deleteTask" className="btn-emp">
              <Button className="btn-add">Delete Tasks</Button>
            </Link>
          </Card.Body>
        </Card>

        <Card>
          <Card.Body>
            <Card.Title>Find Task By Name</Card.Title>
            <Link to="/findtasksbyname" className="btn-emp">
              <Button className="btn-add">Find Task By Name</Button>
            </Link>
          </Card.Body>
        </Card>

        <Card>
          <Card.Body>
            <Card.Title>Your Finished Tasks</Card.Title>
            <Link to="/getfinishedtasks" className="btn-emp">
              <Button className="btn-add">Your Finished Tasks</Button>
            </Link>
          </Card.Body>
        </Card>

        <Card>
          <Card.Body>
            <Card.Title>Your Non-Finished Tasks</Card.Title>
            <Link to="/getnotfinishedtasks" className="btn-emp">
              <Button className="btn-add">Your Non-Finished Tasks</Button>
            </Link>
          </Card.Body>
        </Card>

        <Card>
          <Card.Body>
            <Card.Title>Task Sorted By Due Date</Card.Title>
            <Link to="/gettasksortedbyduedate" className="btn-emp">
              <Button className="btn-add">Task Sorted By Due Date</Button>
            </Link>
          </Card.Body>
        </Card>
      </div>
    </div>
  );
};

export default UserService;
