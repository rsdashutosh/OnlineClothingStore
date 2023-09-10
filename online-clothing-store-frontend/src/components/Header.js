import React from "react";

import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Dropdown } from "react-bootstrap";
import NavDropdown from 'react-bootstrap/NavDropdown';
import { useNavigate } from "react-router-dom";
import ProductService from "../service/ProductService";
import { useState } from "react";
import { useDispatch } from "react-redux";
import { ADD_TO_FETCHED_PRODUCTS, LOGIN, LOGOUT,SEARCH_RESULT } from "../redux/actions/actions";
import { useSelector } from "react-redux";

const Header=(props)=> {

  const [searchText,setSearchText]=useState();
  const [searchSuggestions,setSearchSuggestions]=useState(["SHIRT","T-SHIRT","TROUSERS","SHORTS","JACKET","KURTA","PYJAMA","CAP","SAREE","DRESS","HAT"]);

  const navigate=useNavigate();

  const dispatch = useDispatch();

  const isLogged = useSelector(state => state.loggedReducer);



  // function to set the state at the central store as user is logged out and navigates to login page
  const handleLogout=()=>{
    dispatch(LOGIN())
    alert("logged out successfully!")
    navigate('/login')
  }


  const getdata =useSelector((state) => state.searchReducer.products);

  // fetch products by category and display the results 
  const fetchProductsByCategory=(category)=>{
    console.log("key: "+category)
    ProductService.getProductsByCategory(category).then(result=>{dispatch(SEARCH_RESULT(result.data))})
    // navigate to another page
    navigate('/product_search')
  }

  // after the sending the search term , we fetch the matching suggestions 
  const getSuggestions = (searchTerm) => {
    return searchSuggestions.filter((suggestion) => suggestion.toLowerCase().startsWith(searchTerm.toLowerCase()));
  };

  // after selecting an option from dropdown list, we set it as searchtext
  const handleSelect = (suggestion) => {
    searchText(suggestion);
  };


  const handleSearchBox=(e)=>{
    // get search text 
    e.preventDefault();
    console.log("searchText : "+searchText)

    // match searchText with existing categories
    //const searchCategory=searchSuggestions.find(suggestion=>{suggestion.match(/+{searchText"}+/gi)})

    // find products by the search text 
    ProductService.getProductsByCategory(searchText).then(result=>{dispatch(SEARCH_RESULT(result.data))})
    // display products on the page
    navigate('/product_search')
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
            onSelect={fetchProductsByCategory}
          >
            <NavDropdown title="Mens" id="basic-nav-dropdown">
                <NavDropdown.Item eventKey="CAP">Caps</NavDropdown.Item>
                <NavDropdown.Item eventKey="HAT">Hats</NavDropdown.Item>
                <NavDropdown.Divider />
                <NavDropdown.Item eventKey="SHIRT">Shirts</NavDropdown.Item>
                <NavDropdown.Item eventKey="T_SHIRT">T-Shirts</NavDropdown.Item>
                <NavDropdown.Item eventKey="JACKET">Jackets</NavDropdown.Item>
                <NavDropdown.Item eventKey="KURTA">Kurtas</NavDropdown.Item>
                <NavDropdown.Item eventKey="SWEATER">Sweaters</NavDropdown.Item>
                <NavDropdown.Divider />
                <NavDropdown.Item eventKey="TROUSER">Trousers</NavDropdown.Item>
                <NavDropdown.Item eventKey="JEANS">Jeans</NavDropdown.Item>
                <NavDropdown.Item eventKey="SHORTS">Shorts</NavDropdown.Item>
                <NavDropdown.Item eventKey="PAJAMAS">Pajamas</NavDropdown.Item>
            </NavDropdown>
            <NavDropdown title="Women" id="basic-nav-dropdown">
              <NavDropdown.Item eventKey="SAREE">Saree</NavDropdown.Item>
              <NavDropdown.Item eventKey="DRESS">Dress</NavDropdown.Item>
            </NavDropdown>
          </Nav>
          <Form className="d-flex align-items-center justify-content-center mx-1" onSubmit={handleSearchBox}>
            <Form.Control
              type="search"
              placeholder="Search for products"
              className=""
              aria-label="Search"
              value={searchText}
              onChange={(event) => {setSearchText(event.target.value)}}
            />

            <Button type='submit' className="mx-1" variant="outline-success">Search</Button>
            <Navbar.Text className="mx-1"></Navbar.Text>
          </Form>

          {/* Conditional rendering of user icon and cart icon */}
          {isLogged ? 
          <Form className="d-flex align-items-center justify-content-center mx-4">
          <img class="ml-3" src={require('../images/icons8-cart-pastel-glyph-32.png')} alt="not found" onClick={()=>navigate('/cart')}/>
          <Navbar.Text className="mx-2"></Navbar.Text>
          <NavDropdown title={<img src={require('../images/icons8-user-ios-16-filled-32.png')} alt="not found"/>} id="basic-nav-dropdown" drop="start">
            <NavDropdown.Item onClick={()=>navigate('/profile')}>Profile</NavDropdown.Item>
            <NavDropdown.Item  onClick={()=>navigate('/orders')}>Orders</NavDropdown.Item>
            <NavDropdown.Item  onClick={()=>navigate('/wishlist')}>Wishlist</NavDropdown.Item>
            <NavDropdown.Divider />
            <NavDropdown.Item onClick={handleLogout}>Log Out</NavDropdown.Item>
          </NavDropdown>
          </Form>
          : ''}
          
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default Header;