import React, { useState } from 'react'
import UserService from '../service/UserService';
import { Alert } from 'bootstrap';
import { useNavigate } from 'react-router-dom';
import { useDispatch } from 'react-redux';
import { LOGIN, STORE_USER, STORE_USER_ID } from '../redux/actions/actions';

export default function Login() {

  const dispatch = useDispatch();

  const navigate=useNavigate();

  const [email, setEmail]= useState("Enter email")
  const [password, setPassword]= useState("enter password")
  //const [auth, setAuth]= useState(false)

  const submitHandler=()=>{
    const user={
      "email":email,
      "password":password
    }

    UserService.userAuth(user)
      .then(response=>{
        if(response.data.message==="login successful")
        {
          console.log("success")

          dispatch(STORE_USER_ID(response.data.userId))
          // if role == user then navigate to home , if role == admin navigate to admin dashboard
          navigate('/home');

          // set the loggedIn state as true
          dispatch(LOGIN(true));

          alert("login successful!")
        }
        else
        {
          console.log("failure")
          alert("Login failed!")
        }
      }
    )
  }

  

  return (
    
      
      <div class="container d-flex">
        
        
        
        <div class="row d-flex">
          <div class="col-md-10 float-lg-start justify-content-md-start">
            <img class="img-fluid float-left" src={require('../images/clothing-store.jpeg')} alt='not found'/>
          </div>
          <div class="col-md-2 justify-content-center center text-center align-items-center align-content-md-center">
            <form mt-5>
              <br></br>
              <br></br>
              <br></br>
              <br></br>
              <br></br>
              <br></br>
              <br></br>
              <br></br>
              
              <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Email address</label>
                <input type="email" class="form-control" id="email" aria-describedby="emailHelp" value={email} onChange={(e)=>setEmail(e.target.value)}/>
              </div>
              <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" value={password} onChange={(e)=>setPassword(e.target.value)}/>
              </div>
              
                <button type="button" class="btn btn-primary mx-2" onClick={submitHandler}>Submit</button>
                <button type="button" class="btn btn-primary" onClick={()=>{navigate("/register")}}>Register</button>
                
            </form>
          </div>
          
          

        </div>
     </div>
  )
}
