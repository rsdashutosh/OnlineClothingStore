import React from "react";

import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import { useNavigate } from "react-router-dom";
import ProductService from "../service/ProductService";
import { useState } from "react";
import { useDispatch } from "react-redux";
import { ADD_TO_FETCHED_PRODUCTS, LOGIN, LOGOUT,SEARCH_RESULT } from "../redux/actions/actions";
import { useSelector } from "react-redux";

const Header=()=> {

  const [data,setData]=useState();

  const navigate=useNavigate();

  const dispatch = useDispatch();

  const isLogged = useSelector(state => state.loggedReducer);




  const handleLogout=()=>{
    dispatch(LOGIN())
    alert("logged out successfully!")
    navigate('/login')
  }

  const getdata =useSelector((state) => state.searchReducer.products);
  


  const fetchShirts=()=>{
    ProductService.getProductsByCategory("SHIRT").then(result=>{dispatch(SEARCH_RESULT(result.data))})
    // navigate to another page
    
  }


  return (
    <Navbar expand="lg" bg="dark" data-bs-theme="dark">
      <Container fluid>
        <Navbar.Brand href="#">Online Clothing Store</Navbar.Brand>
        <Navbar.Toggle aria-controls="navbarScroll" />
        <Navbar.Collapse id="navbarScroll">
          <Nav
            className="me-auto my-auto ml-auto mr-auto justify-content-center"
            style={{ maxHeight: '100px' }}
            navbarScroll
          >
            <NavDropdown title="Mens" id="basic-nav-dropdown">
                <NavDropdown.Item onClick={()=>{fetchShirts()}}>Shirts</NavDropdown.Item>
                <NavDropdown.Item>T- Shirts</NavDropdown.Item>
                <NavDropdown.Item>Jackets</NavDropdown.Item>
                <NavDropdown.Divider />
                <NavDropdown.Item href="#action/3.4">
                  Trousers
                </NavDropdown.Item>
                <NavDropdown.Item href="#action/3.4">
                  Shorts
                </NavDropdown.Item>
            </NavDropdown>
            <NavDropdown title="Women" id="basic-nav-dropdown">
              <NavDropdown.Item href="#action/3.1">Saree</NavDropdown.Item>
              <NavDropdown.Item href="#action/3.2">
                Dress
              </NavDropdown.Item>
            </NavDropdown>
            <NavDropdown title="Kids" id="basic-nav-dropdown">
              <NavDropdown.Item href="#action/3.1">Shirts</NavDropdown.Item>
              <NavDropdown.Item href="#action/3.2">
                T Shirts
              </NavDropdown.Item>
                <NavDropdown.Item href="#action/3.3">Pant</NavDropdown.Item>
                <NavDropdown.Divider />
                <NavDropdown.Item href="#action/3.4">
                  Fancy Dress
                </NavDropdown.Item>
            </NavDropdown>
          </Nav>
          <Form className="d-flex align-items-center justify-content-center mx-4">
            <Form.Control
              type="search"
              placeholder="Search"
              className=""
              aria-label="Search"
            />
            <Button className="mx-3" variant="outline-success" onClick={()=>navigate('/product')}>Search</Button>
            <Navbar.Text className="mx-2"></Navbar.Text>
            
            {isLogged ? 
            <>
            <img class="ml-3" src={require('../images/icons8-cart-pastel-glyph-32.png')} alt="not found" onClick={()=>navigate('/cart')}/>
            <Navbar.Text className="mx-2"></Navbar.Text>
            <NavDropdown title={<img src={require('../images/icons8-user-ios-16-filled-32.png')} alt="not found"/>} id="basic-nav-dropdown" drop="start">
              <NavDropdown.Item onClick={()=>navigate('/profile')}>Profile</NavDropdown.Item>
              <NavDropdown.Item  onClick={()=>navigate('/orders')}>Orders</NavDropdown.Item>
              <NavDropdown.Item  onClick={()=>navigate('/wishlist')}>Wishlist</NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item onClick={handleLogout}>Log Out</NavDropdown.Item>
            </NavDropdown>
            </>
            : ''}
          </Form>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default Header;