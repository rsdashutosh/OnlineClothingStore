import React from "react";
import { Container, Row, Col, Card, CardImg, CardBody, CardTitle, CardText, Button } from "reactstrap";
import "./ProductPage.css";

const ProductPage = () => {
  return (
    <Container className="product-page">
      <Row className="justify-content-center">
        <Col md="6" lg="4">
          <Card className="product-card">
            <div className="product-image-container">
              <CardImg src="https://images.pexels.com/photos/6626903/pexels-photo-6626903.jpeg?auto=compress&cs=tinysrgb&w=600" alt="Stud-Tee Product" className="product-image" />
              <p className="image-description">Stylish T-shirt with a vintage aesthetic</p>
            </div>
          </Card>
        </Col>
        <Col md="6" lg="4">
          <Card className="product-card">
            <CardBody className="product-details">
              <CardTitle tag="h2" className="product-title">Stud-Tee</CardTitle>
              <CardText className="product-description">Elevate your style with this vintage-inspired Old Money Aesthetic T-shirt.</CardText>
              <CardText className="product-material">Material: Premium Cotton</CardText>
              <CardText className="product-price">Price: ₹1499</CardText>
              <CardText className="product-delivery">Expected Delivery: 3-5 Business Days</CardText>
              <div className="product-actions">
                <Button color="primary" className="action-button">Add to Cart</Button>
                <Button color="secondary" className="action-button">
                  Add to Wishlist
                </Button>
              </div>
            </CardBody>
          </Card>
        </Col>
      </Row>
    </Container>
  );
};

export default ProductPage;
