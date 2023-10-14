import React from 'react';
import { Container, Row, Col, Card, Button, Nav } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import styles from '../styles/userProfile.css';
import { Table } from "react-bootstrap";
import { useState } from 'react';
import { useNavigate , Link } from 'react-router-dom';
import { useEffect } from 'react';
import UserService from '../service/UserService';
import OrderHistory from './OrderHistory';
import OrderService from '../service/OrderService';
import { useDispatch, useSelector } from 'react-redux';
import { STORE_USER } from '../redux/actions/actions';

const UserProfile = () => {

  const [userData,setUserData]= useState({});

  const userId = useSelector((state) => state.userReducer.userId);

  const userDetails = useSelector((state) => state.userReducer.userDetails);

  const navigate=useNavigate();

  const dispatch=useDispatch();

  useEffect(()=>{
      console.log("in useeffect initialization");
      handleRequestForUsers();
  },[])  

const handleRequestForUsers=()=>{
    UserService.getUserDetails(userId)
    .then(result=>{
        dispatch(STORE_USER(result.data))
        console.log(userDetails.firstName)
    })
}
  

  return (
    <Container className="mt-4">
      <Row>
        <Col md={3}>
          <Card className={styles.profileCard}>
            <Card.Img variant="top" src={require('../images/user.png')} alt="User Profile Image" thumbnail fluid/>
            <Card.Body>
              <Card.Title>Pratik</Card.Title>
              <Card.Text>Fashion Enthusiast</Card.Text>
              <Button variant="primary">Edit Profile</Button>
            </Card.Body>
            <Nav className={`${styles.navLinks} flex-column`}>
              <Nav.Link href="#">Orders</Nav.Link>
              <Nav.Link href="#">Wishlist</Nav.Link>
              <Nav.Link href="#">Saved Addresses</Nav.Link>
              <Nav.Link href="#">Logout</Nav.Link>
            </Nav>
          </Card>
        </Col>
        <Col md={9}>
          <h2>Order history</h2>
        <Table striped bordered hover>
          <thead>
              <tr>
              <th>Payment Id</th>
              <th>Amount</th>
              <th>Payment Method</th>
              <th>Payment Status</th>
              <th>Payment Timestamp</th>
              <th>Order Id</th>
              <th>User Id</th>
              </tr>
          </thead>
          <tbody>
              { 
                  // userData.map(
                  //     (payment)=>(
                  //     <tr key={payment.id}>
                  //         <td>{payment.id}</td>
                  //         <td>{payment.amount}</td>
                  //         <td>{payment.paymentMethod}</td>
                  //         <td>{payment.paymentStatus}</td>
                  //         <td>{payment.paymentTimestamp}</td>
                  //         <td>{payment.orderId}</td>
                  //         <td>{payment.userId}</td>
                  //     </tr>))
              
              }
          </tbody>
          </Table>
          
        </Col>
      </Row>
    </Container>
  );
};

export default UserProfile;
