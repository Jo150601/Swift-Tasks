import React from 'react';
import './Home.css';
import 'bootstrap-icons/font/bootstrap-icons.css';
import { Outlet } from 'react-router-dom';
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import Navbar from 'react-bootstrap/Navbar';
import Card from 'react-bootstrap/Card';
import AdminUserServices from './AdminUserService';

const Home = () => {
  return (
    <div className="container-fluid">
      <Navbar bg="light" expand="lg">
        <Container fluid className="navbar-container">
          <Navbar.Brand className="navbar-brand">Swift Tasks</Navbar.Brand>
          <Navbar.Toggle aria-controls="navbarScroll" />
          <Navbar.Collapse id="navbarScroll">
            <Form className="ms-auto d-flex">
              <Form.Control
                type="search"
                placeholder="Search"
                className="me-2"
                aria-label="Search"
              />
              <Button variant="outline-success">Search</Button>
            </Form>
          </Navbar.Collapse>
        </Container>
      </Navbar>

      <div className="admin-services-container">
        <Card className="admin-service-card">
          <Card.Body>
            <AdminUserServices/>
          </Card.Body>
        </Card>
      </div>
    </div>
  );
};

export default Home;
