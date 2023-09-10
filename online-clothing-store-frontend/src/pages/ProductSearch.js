import React, { useState,useEffect } from "react";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import ProductData from "../data/ProductData";
import '../styles/Products.css';
import {useDispatch} from 'react-redux';
import { ADD } from '../redux/actions/actions';
import UserService from "../service/UserService";
import {useNavigate,useLocation,Link, useParams} from 'react-router-dom';
import ProductService from "../service/ProductService";
import { useSelector } from "react-redux";


const ProductSearch = () => {

//const [data, setData] = useState([]);

const navigate=useNavigate();

const getdata = useSelector((state) => state.searchReducer.products);

    
console.log("shirts : ",getdata);

const dispatch = useDispatch();

const send =(e)=>{
  // console.log(e);
  dispatch(ADD((e)));
}

return (
<div className="container_product d-flex">
  <div className="row center justify-content-center align-content-center align-items-md-center">
  {getdata.map((element) => {
    return (
      <>
        
        <Card style={{ width: "25rem", borderWidth:'2.5px', borderColor:'grey'}} className="card_style">
          <Card.Img variant="top" src={"http://localhost:8080/products/images/"+element.id} className="image_style" style={{width:"300px", height:"350px"}}/>
          <Card.Body>
          <Card.Title className="title_style">{element.name}</Card.Title>
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

export default ProductSearch;