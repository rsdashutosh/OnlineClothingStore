import React from "react";

const OrderHistory=()=>{
    
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
                                <button class="nav-link text-dark" id="nav-orders-on-the-way-tab" data-bs-toggle="tab" data-bs-target="#nav-orders-on-the-way" type="button" role="tab" aria-controls="nav-orders-on-the-way" aria-selected="false"><h4>Orders On the Way</h4></button>
                                <button class="nav-link text-dark" id="nav-cancelled-orders-tab" data-bs-toggle="tab" data-bs-target="#nav-cancelled-orders" type="button" role="tab" aria-controls="nav-cancelled-orders" aria-selected="false"><h4>Cancelled Orders</h4></button>
                            </div>
                        </nav>

                        {/* contents of the tab */ }
                        <div class="tab-content" id="nav-tabContent">
                            <div class="tab-pane fade show active" id="nav-orders" role="tabpanel" aria-labelledby="nav-orders-tab">
                                <div class="card mx-3 my-3">
                                    <div class="card-header">
                                        <div class="row justify-content-center">
                                            <div class="col-md-3 d-flex align-items-center">
                                                <h5>Order placed on <br></br> 26-03-2023</h5>
                                            </div>
                                            <div class="col-md-6 d-flex justify-content-center align-items-center">
                                                <h5>Amount ₹1000 </h5>
                                            </div>
                                            <div class="col-md-3 d-flex align-items-center">
                                                <h5>Order Id : 123</h5>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-md-3">
                                                <img src={require('../images/blue_shirt.jpeg')} class="thumbnail img-fluid rounded float-left" alt="image not found"/>
                                            </div>
                                            <div class="col-md-9">
                                                <div class="row">
                                                    <div class="col-md-8">
                                                        <h5 class="card-title">Mens Blue Shirt</h5><br></br>
                                                        <p class="card-text">order description with order date , order status etc</p>
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
                                <div class="card mx-3 my-3">
                                    <div class="card-header">
                                        <div class="row justify-content-center">
                                            <div class="col-md-3 d-flex align-items-center">
                                                <h5>Order placed on <br></br> 26-03-2023</h5>
                                            </div>
                                            <div class="col-md-6 d-flex justify-content-center align-items-center">
                                                <h5>Amount ₹1000 </h5>
                                            </div>
                                            <div class="col-md-3 d-flex align-items-center">
                                                <h5>Order Id : 123</h5>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-md-3">
                                                <img src={require('../images/red-tshirt.png')} class="thumbnail img-fluid rounded float-left" alt="image not found"/>
                                            </div>
                                            <div class="col-md-9">
                                                <div class="row">
                                                    <div class="col-md-8">
                                                        <h5 class="card-title">Mens Red Shirt</h5><br></br>
                                                        <p class="card-text">order description with order date , order status etc</p>
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

                            </div>
                            <div class="tab-pane fade" id="nav-orders-on-the-way" role="tabpane2" aria-labelledby="nav-orders-on-the-way-tab">
                                <div class="card mx-3 my-3">
                                    <div class="card-header"><h3>Order Id : 1111111</h3>
                                    </div>
                                    <div class="card-body">
                                        <h5 class="card-title">Special title treatment</h5>
                                        <p class="card-text">order description with order date , order status etc</p>
                                        <a href="#" class="btn btn-primary">View Shipping Details</a>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="nav-cancelled-orders" role="tabpane3" aria-labelledby="nav-cancelled-orders-tab">
                            <div class="card mx-3 my-3">
                                <div class="card-header"><h3>Order Id : 45654654</h3>
                                    </div>
                                    <div class="card-body">
                                        <h5 class="card-title">Special title treatment</h5>
                                        <p class="card-text">order description with order date , order status etc</p>
                                        <a href="#" class="btn btn-primary">View Shipping Details</a>
                                    </div>
                                </div>
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