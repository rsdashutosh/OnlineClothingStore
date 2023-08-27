import React from 'react';
import { Container, Row, Col, Card, Button, Nav } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import styles from './userProfile.css';

const UserProfile = () => {
  return (
    <Container className="mt-4">
      <Row>
        <Col md={3}>
          <Card className={styles.profileCard}>
            <Card.Img variant="top" src="user-profile-image.jpg" alt="User Profile Image" />
            <Card.Body>
              <Card.Title>Pratik</Card.Title>
              <Card.Text>Fashion Enthusiast</Card.Text>
              <Button variant="primary">Edit Profile</Button>
            </Card.Body>
            <Nav className={`${styles.navLinks} flex-column`}>
              <Nav.Link href="#">Orders</Nav.Link>
              <Nav.Link href="#">Wishlist</Nav.Link>
              <Nav.Link href="#">Contact Us</Nav.Link>
              <Nav.Link href="#">New Credit</Nav.Link>
              <Nav.Link href="#">Coupons</Nav.Link>
              <Nav.Link href="#">Saved Addresses</Nav.Link>
              <Nav.Link href="#">Logout</Nav.Link>
            </Nav>
          </Card>
        </Col>
        <Col md={9}>
          <h2>Order History</h2>
          <ul className="list-group">
            <li className="list-group-item">Order 1 - Total: $150.00</li>
            <li className="list-group-item">Order 2 - Total: $99.99</li>
            {/* Add more order items here */}
          </ul>
        </Col>
      </Row>
    </Container>
  );
};

export default UserProfile;
