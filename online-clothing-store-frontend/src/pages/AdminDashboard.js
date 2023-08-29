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
import { Table } from "react-bootstrap";
import OrderService from "../service/OrderService";
import PaymentService from "../service/PaymentService";

const Admin = () => {

const [productData, setProductData] = useState([]);
const [userData, setUserData] = useState([]);
const [orderData,setOrderData]= useState([]);
const [paymentData,setPaymentData]= useState([]);

const navigate=useNavigate();



useEffect(()=>{
    console.log("in useeffect initialization");
    handleRequestForUsers();
    handleRequestForProducts();
    handleRequestForOrders();
    handleRequestForPayments();
},[])  

const handleRequestForProducts=()=>{
    console.log("in handle request for product");
    ProductService.getAllProducts()
    .then(result=>{
        setProductData(result.data)
    })
}

const handleRequestForUsers=()=>{
    console.log("in handle request for users");
    UserService.getAllUsers()
    .then(result=>{
        setUserData(result.data)
    })
}

const handleRequestForOrders=()=>{
    console.log("in handle request for orders ");
    OrderService.getAllOrders()
    .then(result=>{
        setOrderData(result.data)
    })
}

const handleRequestForPayments=()=>{
    console.log("in handle request for payment");
    PaymentService.getAllPayments()
    .then(result=>{
        setPaymentData(result.data)
    })
}


const dispatch = useDispatch();

const send =(e)=>{
  // console.log(e);
  dispatch(ADD((e)));
}

const deleteEmp=()=>{}

return (
        <div class="row d-flex align-items-start">
                        <div class="col-3 nav flex-column nav-pills  bg-dark text-white min-vh-100" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                            <br></br>
                            <h4>Admin Dashboard</h4>
                            <br></br>
                            <button class="nav-link active btn-secondary" id="v-pills-products-tab" data-bs-toggle="pill" data-bs-target="#v-pills-products" type="button" role="tab" aria-controls="v-pills-products" aria-selected="false"><h5>Products</h5></button>
                            <button class="nav-link btn-secondary" id="v-pills-users-tab" data-bs-toggle="pill" data-bs-target="#v-pills-users" type="button" role="tab" aria-controls="v-pills-users" aria-selected="true"><h5>Users</h5></button>
                            <button class="nav-link btn-secondary" id="v-pills-orders-tab" data-bs-toggle="pill" data-bs-target="#v-pills-orders" type="button" role="tab" aria-controls="v-pills-orders" aria-selected="false"><h5>Orders</h5></button>
                            <button class="nav-link btn-secondary" id="v-pills-payments-tab" data-bs-toggle="pill" data-bs-target="#v-pills-payments" type="button" role="tab" aria-controls="v-pills-payments" aria-selected="false"><h5>Payments</h5></button>

                        </div>
                        <div class="col-3 tab-content" id="v-pills-tabContent">
                            <div class="tab-pane fade" id="v-pills-users" role="tabpanel" aria-labelledby="v-pills-profile-tab">
                            <Table striped bordered hover>
                                <thead>
                                    <tr>
                                    <th>User Id</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Email</th>
                                    <th>Phone Number</th>
                                    <th>Role</th>
                                    <th>Gender</th>
                                    <th>Date Of Birth</th>
                                    <th>Coins</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    { 
                                        userData.map(
                                            (user)=>(
                                            <tr key={user.id}>
                                                <td>{user.id}</td>
                                                <td>{user.firstName}</td>
                                                <td>{user.lastName}</td>
                                                <td>{user.email}</td>
                                                <td>{user.phoneNumber}</td>
                                                <td>{user.role}</td>
                                                <td>{user.gender}</td>
                                                <td>{user.dateOfBirth}</td>
                                                <td>{user.coins}</td>
                                                
                                                
                                                <td><button type="button" className="btn btn-danger" onClick={()=>{deleteEmp(user.id)}}>delete</button>

                                    &nbsp;&nbsp;&nbsp;
                                    <Link to={{pathname:`/add/${user.id}`,state:{emp:user}}}>
                                    <button type="button" className="btn btn-success">edit</button>
                                    </Link>
                                    &nbsp;&nbsp;&nbsp;<button type="button" className="btn btn-info">view</button> </td></tr>))
                                    
                                    }
                                </tbody>
                                </Table>
                            </div>
                            <div class="tab-pane fade" id="v-pills-products" role="tabpanel" aria-labelledby="v-pills-messages-tab">
                            <Table striped bordered hover>
                                <thead>
                                    <tr>
                                    <th>Product Id</th>
                                    <th>Category</th>
                                    <th>Color</th>
                                    <th>Description</th>
                                    <th>Discount</th>
                                    <th>Gender</th>
                                    <th>Material</th>
                                    <th>Size</th>
                                    <th>Price</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    { 
                                        productData.map(
                                            (product)=>(
                                            <tr key={product.id}>
                                                <td>{product.id}</td>
                                                <td>{product.category}</td>
                                                <td>{product.color}</td>
                                                <td>{product.description}</td>
                                                <td>{product.discount}</td>
                                                <td>{product.gender}</td>
                                                <td>{product.material}</td>
                                                <td>{product.size}</td>
                                                <td>{product.price}</td>
                                                
                                                
                                                <td><button type="button" className="btn btn-danger" onClick={()=>{deleteEmp(product.id)}}>delete</button>

                                    &nbsp;&nbsp;&nbsp;
                                    <Link to={{pathname:`/add/${product.id}`,state:{emp:product}}}>
                                    <button type="button" className="btn btn-success">edit</button>
                                    </Link>
                                    &nbsp;&nbsp;&nbsp;<button type="button" className="btn btn-info">view</button> </td></tr>))
                                    
                                    }
                                </tbody>
                                </Table>
                            </div>
                            <div class="tab-pane fade" id="v-pills-orders" role="tabpanel" aria-labelledby="v-pills-settings-tab">
                            <Table striped bordered hover>
                                <thead>
                                    <tr>
                                    <th>Id</th>
                                    <th>Order Date</th>
                                    <th>Order Status</th>
                                    <th>Tax</th>
                                    <th>Order Amount</th>
                                    <th>User Id</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    { 
                                        orderData.map(
                                            (order)=>(
                                            <tr key={order.id}>
                                                <td>{order.id}</td>
                                                <td>{order.orderDate}</td>
                                                <td>{order.orderStatus}</td>
                                                <td>{order.tax}</td>
                                                <td>{order.orderAmount}</td>
                                                <td>{order.userId}</td>
                
                                                
                                                
                                                <td><button type="button" className="btn btn-danger" onClick={()=>{deleteEmp(order.id)}}>delete</button>

                                    &nbsp;&nbsp;&nbsp;
                                    <Link to={{pathname:`/add/${order.id}`,state:{emp:order}}}>
                                    <button type="button" className="btn btn-success">edit</button>
                                    </Link>
                                    &nbsp;&nbsp;&nbsp;<button type="button" className="btn btn-info">view</button> </td></tr>))
                                    
                                    }
                                </tbody>
                                </Table>
                            </div>
                            <div class="tab-pane fade" id="v-pills-payments" role="tabpanel" aria-labelledby="v-pills-profile-tab">
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
                                        paymentData.map(
                                            (payment)=>(
                                            <tr key={payment.id}>
                                                <td>{payment.id}</td>
                                                <td>{payment.amount}</td>
                                                <td>{payment.paymentMethod}</td>
                                                <td>{payment.paymentStatus}</td>
                                                <td>{payment.paymentTimestamp}</td>
                                                <td>{payment.orderId}</td>
                                                <td>{payment.userId}</td>
                                                
                                                
                                                
                                                <td><button type="button" className="btn btn-danger" onClick={()=>{deleteEmp(payment.id)}}>delete</button>

                                    &nbsp;&nbsp;&nbsp;
                                    <Link to={{pathname:`/add/${payment.id}`,state:{emp:payment}}}>
                                    <button type="button" className="btn btn-success">edit</button>
                                    </Link>
                                    &nbsp;&nbsp;&nbsp;<button type="button" className="btn btn-info">view</button> </td></tr>))
                                    
                                    }
                                </tbody>
                                </Table>
                            </div>
                        </div>
                    </div>
  )
};

export default Admin;