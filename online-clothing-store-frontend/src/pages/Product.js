import React, { useState } from "react";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import ProductData from "./ProductData";
import './Product.css';
import {useDispatch} from 'react-redux';
import { ADD } from '../redux/actions/actions';


const Product = () => {
  const [data, setData] = useState(ProductData);
  //console.log(data);

const dispatch = useDispatch();

const send =(e)=>{
 // console.log(e);
 dispatch(ADD(e));
}

  return (
    <div className="container_product">
      <h1 style={{alignContent:"center"}}>This is product page</h1>
      <div className="row">
        {data.map((element, id) => {
          return (
            <>
              <Card style={{ width: "25rem", borderWidth:'2.5px', borderColor:'grey'}} className="card_style">
                <Card.Img variant="top" src={element.imgdata} className="image_style" style={{width:"300px", height:"350px"}}/>
                <Card.Body>
                <Card.Title className="title_style">{element.rname}</Card.Title>
                  <Card.Text className="text_style">Price: ₹{element.price} </Card.Text>
                  <div className="button_div"> 
                  <Button variant="primary" 
                  onClick ={()=>send(element)}
                  className='col-lg-8'>Add to Cart</Button></div>
                </Card.Body>
              </Card>
            </>
          );
        })}
      </div>
    </div>
  );
};

export default Product;
