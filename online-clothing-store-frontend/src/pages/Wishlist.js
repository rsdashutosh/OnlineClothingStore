import React from 'react';
import { Container, Row, Col, Card, Button } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import styles from './wishlist.css';

const Wishlist = () => {
  const products = [
    { id: 1, name: 'Product 1', price: 2000, image: 'product1.jpg' },
    { id: 2, name: 'Product 2', price: 3000, image: 'product2.jpg' },
    { id: 3, name: 'Product 3', price: 4000, image: 'product3.jpg' },
    // Add more products here
  ];

  const handleMoveToBag = (productId) => {
    // Implement the move to bag functionality here
    console.log(`Product ${productId} moved to bag`);
  };

  const handleRemove = (productId) => {
    // Implement the remove functionality here
    console.log(`Product ${productId} removed from wishlist`);
  };

  return (
    <Container className="mt-4">
      <h2>Your Wishlist</h2>
      <Row>
        {products.map(product => (
          <Col key={product.id} md={4} className="mb-4">
            <Card>
              <Card.Img variant="top" src={product.image} alt={product.name} />
              <Card.Body>
                <Card.Title>{product.name}</Card.Title>
                <Card.Text>Rs.{product.price}</Card.Text>
                <div className="d-flex flex-column align-items-center">
                  <Button variant="primary" className={styles.moveButton} onClick={() => handleMoveToBag(product.id)}>
                    Move to Bag
                  </Button>
                  <Button variant="danger" className={`${styles.removeButton} mt-2`} onClick={() => handleRemove(product.id)}>
                    Remove
                  </Button>
                </div>
              </Card.Body>
            </Card>
          </Col>
        ))}
      </Row>
    </Container>
  );
};

export default Wishlist;
