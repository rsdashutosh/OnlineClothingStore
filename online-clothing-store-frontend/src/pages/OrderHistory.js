import React from "react";
import { useState } from "react";
import { useEffect } from "react";
import OrderService from "../service/OrderService";
import { useSelector } from "react-redux";
import { useDispatch } from "react-redux";
import { STORE_ORDERS } from "../redux/actions/actions";

const OrderHistory=()=>{
    // get orders for a particular user
    useEffect(() => { getOrderData() }, [])

    const dispatch = useDispatch();

    const orderData = useSelector((state) => state.orderReducer.orders);

    function getOrderData(){
        const userId=9;
        OrderService.getAllOrdersOfACustomer(userId).then(result=>{dispatch(STORE_ORDERS(result.data))})
        
        // get products of each order
         
    }

    
    
    return(
    
        <div class="container bg-light ">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <div class="border mt-5 bg-white">
                        {/* nav links of the tab */ }
                        <nav>
                            <div class="nav nav-tabs" id="nav-tab" role="tablist">
                                <button class="nav-link active text-dark" id="nav-order-tab" data-bs-toggle="tab" data-bs-target="#nav-orders" type="button" role="tab" aria-controls="nav-orders" aria-selected="false"><h4>Orders</h4></button>
                            </div>
                        </nav>

                        {/* contents of the tab */ }
                        <div class="tab-content" id="nav-tabContent">
                            <div class="tab-pane fade show active" id="nav-orders" role="tabpanel" aria-labelledby="nav-orders-tab">
                                
                            {orderData.map((order) => {
                                return (
                                <>
                                    <div class="card mx-3 my-3">
                                        <div class="card-header">
                                            <div class="row justify-content-center">
                                                <div class="col-md-3 d-flex align-items-center">
                                                    <h5>Order placed on <br></br> {order.orderDate}</h5>
                                                </div>
                                                <div class="col-md-6 d-flex justify-content-center align-items-center">
                                                    <h5>Amount ₹{order.orderAmount} </h5>
                                                </div>
                                                <div class="col-md-3 d-flex align-items-center">
                                                    <h5>Order Id : {order.id}</h5>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col-md-3">
                                                    <img src={"http://localhost:8080/products/images/"+order.productId} class="thumbnail img-fluid rounded float-left" alt="not found!"/>
                                                </div>
                                                <div class="col-md-9">
                                                    <div class="row">
                                                        <div class="col-md-8">
                                                            <h5 class="card-title">{order.productName}</h5><br></br>
                                                            <p class="card-text">{order.productDescription}</p>
                                                        </div>
                                                        <div class="col-md-4 d-grid gap-2 mx-auto">
                                                            <a href="#" class="btn btn-success my-1">Write Review</a>
                                                            <a href="#" class="btn btn-danger my-1">Return or Exchange</a>
                                                            <a href="#" class="btn btn-primary my-1">Track Order</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </>
                                );
                                })}    

                                

                            </div>
                            
                        </div>
                    </div> 
                </div>
                <div class="col-md-3">
                </div>
            </div>
        </div>
        
    )
}

export default OrderHistory;