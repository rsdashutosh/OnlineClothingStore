import React, { useState } from "react";
import Button from "react-bootstrap/Button";
import Container from "react-bootstrap/Container";
import Form from "react-bootstrap/Form";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import NavDropdown from "react-bootstrap/NavDropdown";
import {NavLink} from 'react-router-dom';
import Badge, { BadgeProps } from "@mui/material/Badge";
import Menu from "@mui/material/Menu";
import MenuItem from "@mui/material/MenuItem";
import { DELETE } from "../redux/actions/actions";
import {useSelector} from "react-redux";
import {useDispatch} from "react-redux";
import {useEffect} from 'react'
// import { NavLink } from "react-bootstrap";

function NavScrollExample() {
  const getdata = useSelector((state) => state.cartreducer.carts);
  console.log(getdata);

  const [anchorEl, setAnchorEl] = useState(null);
  const open = Boolean(anchorEl);
  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = () => {
    setAnchorEl(null);
  };

  const dispatch = useDispatch();

  const dlt = (id)=>{
    dispatch(DELETE(id))
  }

  //to set total price
  const[price, setPrice] = useState(0);
 // console.log(price);

  const total =()=>{
   let price = 0;
   getdata.map((ele,k)=>{
     price = ele.price * ele.qnty + price;
   });
   setPrice(price);
  };

  useEffect(() => { total(); }, [total])

  return (
    <Navbar
      expand="lg"
      className="bg-body-tertiary fixed-top"
      style={{ height: 80 }}
    >
      <Container fluid>
        <Navbar.Brand href="#">Online clothing Store</Navbar.Brand>
        <Navbar.Toggle aria-controls="navbarScroll" />
        <Navbar.Collapse id="navbarScroll">
          <Nav
            className="me-auto my-2 my-lg-0"
            style={{ maxHeight: "100px" }}
            navbarScroll
          >
            <Badge
              badgeContent={getdata.length}
              color="primary"
              id="basic-button"
              aria-controls={open ? "basic-menu" : undefined}
              aria-haspopup="true"
              aria-expanded={open ? "true" : undefined}
              onClick={handleClick}
            >
              <i
                class="fa fa-shopping-cart"
                aria-hidden="true"
                style={{ fontSize: 40, cursor: "pointer" , color:"lightslategray"}}
              ></i>
            </Badge>

            <NavDropdown title="Men" id="navbarScrollingDropdown">
              <NavDropdown.Item href="#action3">T-Shirts </NavDropdown.Item>
              <NavDropdown.Item href="#action4">Trousers </NavDropdown.Item>
              <NavDropdown.Item href="#action5">Trackpants</NavDropdown.Item>
              <NavDropdown.Item href="#action5">Formal Shirts</NavDropdown.Item>
              <NavDropdown.Item href="#action5">
                Causual Shirts
              </NavDropdown.Item>
              <NavDropdown.Item href="#action5">Jackets</NavDropdown.Item>
              <NavDropdown.Item href="#action5">
                Blazers & Coats
              </NavDropdown.Item>
              <NavDropdown.Item href="#action5">Suits</NavDropdown.Item>
            </NavDropdown>

            <NavDropdown title="Women" id="navbarScrollingDropdown">
              <NavDropdown.Item href="#action3">
                Kurtis, Tunics & Tops{" "}
              </NavDropdown.Item>
              <NavDropdown.Item href="#action4">
                Kurtas & Suits{" "}
              </NavDropdown.Item>
              <NavDropdown.Item href="#action5">Sarees</NavDropdown.Item>
              <NavDropdown.Item href="#action5">Ethnic Wear</NavDropdown.Item>
              <NavDropdown.Item href="#action5">
                Leggings, Salwars & Chudidars
              </NavDropdown.Item>
              <NavDropdown.Item href="#action5">
                Blazers & Coats
              </NavDropdown.Item>
              <NavDropdown.Item href="#action5">
                Lehenga cholis
              </NavDropdown.Item>
              <NavDropdown.Item href="#action5">
                Dupattas & Shawls
              </NavDropdown.Item>
              <NavDropdown.Item href="#action5">Swaeters</NavDropdown.Item>
            </NavDropdown>

            <NavDropdown title="Kids" id="navbarScrollingDropdown">
              <NavDropdown.Item href="#action3">T-Shirts </NavDropdown.Item>
              <NavDropdown.Item href="#action4">Pants </NavDropdown.Item>
              <NavDropdown.Item href="#action5">Frocks</NavDropdown.Item>
              <NavDropdown.Item href="#action5">Party Wear</NavDropdown.Item>
              <NavDropdown.Item href="#action5">
                Jackets & Sweaters{" "}
              </NavDropdown.Item>
              <NavDropdown.Item href="#action5">
                Innerwears & Thermals
              </NavDropdown.Item>
              <NavDropdown.Item href="#action5">Nightwears</NavDropdown.Item>
              <NavDropdown.Item href="#action5">Jeans</NavDropdown.Item>
              <NavDropdown.Item href="#action5">Shorts</NavDropdown.Item>
            </NavDropdown>

            <NavDropdown title="Login" id="navbarScrollingDropdown">
              <NavDropdown.Item href="#action3">My Profile </NavDropdown.Item>
              <NavDropdown.Item href="#action4">Orders</NavDropdown.Item>
              <NavDropdown.Item href="#action5">Coins</NavDropdown.Item>
              <NavDropdown.Item href="#action5">Offers</NavDropdown.Item>
            </NavDropdown>
          </Nav>

          <Form className="d-flex">
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

      <Menu
        id="basic-menu"
        anchorEl={anchorEl}
        open={open}
        onClose={handleClose}
        MenuListProps={{
          "aria-labelledby": "basic-button",
        }}
      >
        {getdata.length ? (
          <div className="card_details" style={{width:"300px"}}>
            <table>
              <thead>
                <h4> Shopping cart</h4>
              </thead>
              <tbody>
                {
                getdata.map((e)=>{
                  return (
                    <>
                   <tr>
                      <td>
                       <NavLink to={'/productdtls/${e.id}'}> <img src={e.imgdata}  style={{width:"7rem", height:"10rem"}} alt=""></img>  </NavLink> 
                      </td>
                      <td> 
                        <p> <small style={{color:"green"}}> In Stock</small></p>
                        <p>{e.rname}</p>
                        <p>₹ {e.price}</p>
                        <p> <strong>Size:</strong> {e.size}</p>
                        <p><strong>Color:</strong> {e.color}</p>
                        <p><strong>Quantity:</strong> {e.qnty}</p>
                        <p style={{color:"red", fontSize:20, cursor:"pointer"}}onClick={()=>dlt(e.id)}>
                          <i className='fas fa-trash'> </i>
                        </p>
                      </td>
                   </tr>

                    </>
                  )
                })
              }
               <p> <strong>Total:</strong> ₹ {price}</p> 
             </tbody>
            </table>
          </div>
        ) : (
          <div
            className="cart_details d-flex justify-content-center align-items-center"
            style={{ width: "20rem", padding: 10, position: "relative" }}
          >
            <i
              className="fas fa-close smallclose"
              onClick={handleClose}
              style={{
                position: "absolute",
                top: 2,
                right: 20,
                fontSize: 25,
                cursor: "pointer",
              }}
            >
              {" "}
            </i>
            <p style={{ fontSize: 20 }}>Your cart is empty</p>
            <img
              src="./images/cart.gif"
              alt=""
              className="cart_img"
              style={{ width: "5rem", padding: 5 }}
            />
          </div>
        )}
      </Menu>
    </Navbar>
  );
}

export default NavScrollExample;
