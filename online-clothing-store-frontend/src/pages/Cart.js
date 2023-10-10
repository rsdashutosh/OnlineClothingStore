import React from 'react'
import { DELETE , WISHLIST} from "../redux/actions/actions";
import {useSelector} from "react-redux";
import {useDispatch} from "react-redux";
import {useState} from 'react'
import {useEffect} from 'react'
import OrderService from '../service/OrderService';
import { useNavigate } from 'react-router-dom';

export default function Cart() {
    //to set total price
    const[price, setPrice] = useState(0);
    const[totalDiscount, setDiscount] = useState(0);
    const[responseReceived, setResponseReceived] = useState(false);
     // console.log(price);

     const dispatch = useDispatch();
     const navigate=useNavigate();

    const getdata = useSelector((state) => state.cartreducer.carts);
    //console.log(getdata);


    const dlt = (id)=>{
        dispatch(DELETE(id))
    }

    const moveToWishlist = (id)=>{
        dispatch(WISHLIST(id))
    }

    // calculates the total amount for the products in the cart
    const total=()=>{
        let price = 0;
        getdata.map((ele,k)=>{
            price = ele.price * ele.qnty + price;
        });
        setPrice(price);
    };

    // calculates the discount amount for the products in the cart
    const discount=()=>{
        let discount = 0;
        getdata.map((ele,k)=>{
            discount=(price*ele.discount*0.01)*ele.qnty + discount;
        });
        setDiscount(discount);
    };


    // method to define how the order will be placed
    const placeOrder=()=>{
        // get the products currently place in the cart 
        const cartItems=getdata;
        const productsIds=[];

        // create an array of   product ids of all the products in the cart
        cartItems.forEach((cartItem)=>{productsIds.push(cartItem.id)})
        console.log(productsIds)
        
        // create the DTO containing the user id and the product ids
        const orderDetails={userId:9,productIds:productsIds}

        // send these order details to backend for create the order
        OrderService.addOrdersFromCart(orderDetails)
        .then(
            response=>{
                if(response.data==="order placed successfully!" && responseReceived===false){
                    console.log(response.data)
                    setResponseReceived(true);
                    alert("Order placed successfully!");
                }else{
                    console.log("failure")
                    setResponseReceived(true);
                    alert("Order could not be placed, please try again :( ");
                }
            }
            
        )

        setResponseReceived(false);

        // code to empty the cart
        cartItems.forEach((cartItem)=>dlt(cartItem.id));

        // navigate to orders page
        navigate("/orders")

        // on successful placing of order , remove the items from the cart
        alert("Order successfully placed !");
        
    }


    useEffect(() => { total();discount() }, [total,discount])
    

  return (
    <div className='container'>
      <div className='row my-5 d-flex'>
        <div className='col-1'></div>
        <div className="col-7 card d-flex justify-content-center align-content-between">
          <div className="card-body min-vh-100" >
            <h2>Shopping Cart</h2>
            
            {getdata.map((element) => {
            return (
            <>
                <div class="card mx-3 my-3">
                    <div class="card-header">
                        <div class="row justify-content-center">
                            <div class="col-md-3 d-flex align-items-center">
                            </div>
                            <div class="col-md-6 d-flex justify-content-center align-items-center">
                                <h6>Price ₹ {element.price}</h6>
                            </div>
                            <div class="col-md-3 d-flex align-items-center">
                                <h6>Qty : {element.qnty}</h6>
                            </div>
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-3">
                                <img src={"http://localhost:8080/products/images/"+element.id} class="thumbnail img-fluid rounded float-left" alt="not found"/>
                            </div>
                            <div class="col-md-9">
                                <div class="row">
                                    <div class="col-md-9">
                                        <h6 class="card-title">{element.name}</h6><br></br>
                                        <p class="card-text">{element.description}</p>
                                    </div>
                                    <div class="col-md-3 d-grid gap-2 mx-auto">
                                        <a href="#" class="btn btn-danger my-1" onClick={()=>dlt(element.id)} >Remove from Cart</a>
                                        <a href="#" class="btn bg-warning my-1" onClick={()=>moveToWishlist(element.id)}>Move To Wishlist</a>
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



        <div className="col-3 card m-5 align-content-center">
          <br></br>
          <br></br>
          <br></br>
          <br></br>
          <br></br>
            <h4>Price Details</h4>
            <h6>Total MRP ₹{price}</h6>
            <h6>Discount on MRP - ₹{totalDiscount}</h6>
            <hr></hr>
            <h6>Total Amount ₹{price-totalDiscount}</h6>
            <a href="#" class="btn bg-success my-1 text-white">Place Order</a>
        </div>
        <div className='col-1'></div>
      </div>
    

    </div>
  )
}
