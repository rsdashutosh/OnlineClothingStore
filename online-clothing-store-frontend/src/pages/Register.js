import React, { useState } from 'react'
import UserService from '../service/UserService';
import { Alert } from 'bootstrap';
import { useNavigate } from 'react-router-dom';

export default function Register() {

  const navigate=useNavigate();

  const [firstName, setFirstName]= useState("Enter First name")
  const [lastName, setLastName]= useState("enter Last name")
  const [email, setEmail]= useState("Enter email")
  const [phoneNumber, setPhoneNumber]= useState("enter phone number")
  const [password, setPassword]= useState("Enter password")
  const [gender, setGender]= useState("enter gender")
  const [dateOfBirth, setDateOfBirth]= useState("enter dob")
  //const [auth, setAuth]= useState(false)

  const submitHandler=()=>{
    // construct the json here
    const user={
      "firstName":firstName,
      "lastName":lastName,
      "email":email,
      "phoneNumber":phoneNumber,
      "password":password,
      "gender":gender,
      "dateOfBirth":dateOfBirth
    }


    UserService.addUser(user)
      .then(response=>{
        if(response.data==="success")
        {
          alert("registration successful!")
          console.log("registration successful")
          // if role == user then navigate to home , if role == admin navigate to admin dashboard
          navigate('/login');
        }
        else
        {
          console.log("failure")
          alert("registration failed!")
        }
      }
    )
  }

  

  return (
    
      
      <div class="container">
        <div class="row">
          <div class="col-md-4">
            <form mt-5>
              <br></br>
              
              <div class="mb-3">
                <label for="firstName" class="form-label">FirstName</label>
                <input type="text" class="form-control" id="firstName" aria-describedby="emailHelp" value={firstName} onChange={(e)=>setFirstName(e.target.value)}/>
              </div>

              <div class="mb-3">
                <label for="lastName" class="form-label">Last Name</label>
                <input type="text" class="form-control" id="lastName" aria-describedby="emailHelp" value={lastName} onChange={(e)=>setLastName(e.target.value)}/>
              </div>

              <div class="mb-3">
                <label for="email" class="form-label">Email Address</label>
                <input type="email" class="form-control" id="email" aria-describedby="emailHelp" value={email} onChange={(e)=>setEmail(e.target.value)}/>
              </div>

              <div class="mb-3">
                <label for="phoneNumber" class="form-label">Phone Number</label>
                <input type="text" class="form-control" id="phoneNumber" aria-describedby="emailHelp" value={phoneNumber} onChange={(e)=>setPhoneNumber(e.target.value)}/>
              </div>

              <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" value={password} onChange={(e)=>setPassword(e.target.value)}/>
              </div>

              <div class="mb-3">
                
                <label for="gender" class="form-label">Gender</label>
                <input type="text" class="form-control" id="gender" aria-describedby="emailHelp" value={gender} onChange={(e)=>setGender(e.target.value)}/>
              
              </div>

              <div class="mb-3">
                <label for="dateOfBirth" class="form-label">Date Of Birth</label>
                <input type="date" class="form-control" id="dateOfBirth" aria-describedby="emailHelp" value={dateOfBirth} onChange={(e)=>setDateOfBirth(e.target.value)}/>
              </div>
                <button type="button" class="btn btn-primary mx-1" onClick={()=>{navigate("/login")}}>Back to Login</button>
                <button type="button" class="btn btn-primary mx-1" onClick={submitHandler}>Register</button>
                <button type="button" class="btn btn-primary mx-1" onClick={()=>{navigate("/register")}}>Reset</button>
            </form>
          </div>
          <div class="col-md-8">
            <img class="h-100 img-fluid float-right object-fit-cover border rounded" src={require('../images/clothing-rak.avif')} alt='not found'/>
          </div>
          

        </div>
     </div>
  )
}
