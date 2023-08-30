import React from 'react'
import { useState } from 'react';
import WishlistService from '../service/WishlistService';
import { Card,Button, Container, Row, Col } from 'react-bootstrap';
import { useSelector } from 'react-redux';
import { useDispatch } from 'react-redux';
import { MOVE_TO_CART,REMOVE_FROM_WISHLIST } from '../redux/actions/actions';

export default function Wishlist() {

  const dispatch = useDispatch();

    const getdata = useSelector((state) => state.cartreducer.wishlists);
    console.log("wishlist: ",getdata);

    const moveToCart = (id)=>{
      dispatch(MOVE_TO_CART(id))
    }

    const removeFromWishlist = (id)=>{
      dispatch(REMOVE_FROM_WISHLIST(id))
    }


  return (

        <div className="container_product d-flex">
          
          <div className="row center justify-content-center align-content-center align-items-md-center">
            {getdata.map((element) => {
              return (
                <>
                  
                  <Card style={{ width: "25rem", borderWidth:'2.5px', borderColor:'grey'}} className="card_style" id={element.id}>
                    <Card.Img variant="top" src={"http://localhost:8080/products/images/"+element.id} className="image_style" style={{width:"300px", height:"350px"}}/>
                    <Card.Body>
                    <Card.Title className="title_style">{element.name}</Card.Title>
                    <Card.Text className="text_style">Price: ₹{element.price}</Card.Text>
                    <div className="button_div">
                    <Button variant="primary" className='col-4 btn-success mx-4' onClick={()=>moveToCart(element.id)}>Move to Cart</Button>
                    <Button variant="primary" className='col-4 btn-danger mx-4' onClick={()=>removeFromWishlist(element.id)}>Remove</Button>
                    </div>
                    </Card.Body>
                  </Card>
                </>
              );
              })}
            </div>
          </div>
  )
}
