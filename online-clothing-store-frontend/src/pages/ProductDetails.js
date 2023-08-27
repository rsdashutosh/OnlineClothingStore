// import React from "react";
// import Table from "react-bootstrap/Table";
// import './ProductDetails.css';
// import { useParams } from "react-router-dom";
// import { useSelector } from "react-redux";
// import {useState} from 'react';
// import {useEffect} from 'react';

// const ProductDetails = () => {

//   const [data, setData] = useState([])
//   console.log(data);
  
//   const {id} = useParams();
//   //console.log(id);

//   const getdata = useSelector((state) => state.cartreducer.carts);
//   //console.log(getdata);

//   const compare = ()=>{
//     let comparedata = getdata.filter((e)=>{
//         return e.id == id
//     });
//     setData(comparedata)
//   }



//   useEffect(() => {compare()}, [id])
  
//   return (
//     <>
//     <div
//       className="container_pd"
//       style={{ display: "flex", alignItems: "center" }}>
//       <h2 className="text-center"> Product details page</h2>

//       <section className="container mt-3" style={{ display: "flex"}}>
//         <div className="itemsdetails" style={{ display: "flex", alignItems: "center" }}>
//         {
//           data.map((ele)=>{
//             return(
//               <>
            
//           <div className="items_img">
//             <img
//               src="ele.imgdata"
//               alt=""
//               style={{ width: "250px", height: "350px" }}
//             ></img>
//           </div>
    
//         <div className="details" style={{ flex: 1, marginLeft: "20px" }}>
//           <table>
//             <tbody>
//               <tr>
//                 <td>
//                   <p>
//                     <strong>Brand</strong> Pushpanjali
//                   </p>
//                   <p>
//                     <strong>Price</strong> ₹30000
//                   </p>
//                   <p>
//                     <strong>Discount</strong> 30% off
//                   </p>
//                   <p>
//                     <strong>Size</strong> L
//                   </p>
//                   <p>
//                     <strong>Total</strong> ₹30000
//                   </p>
//                 </td>
//                 <td>
//                   <p>
//                     <strong>Description</strong> Floral Mysore silk saree
//                   </p>
//                   <p>
//                     <strong>Material</strong> Silk
//                   </p>
//                   <p>
//                     <strong>Ratings</strong>{" "}
//                     <span
//                       style={{
//                         background: "green",
//                         color: "#fff",
//                         padding: "2px 5px",
//                         borderRadius: "5px",
//                       }}
//                     >
//                       4.2 ★
//                     </span>
//                   </p>
//                   <p>
//                     <strong>Reviews</strong>{" "}
//                     <span>1175+ orders placed from here recently</span>
//                   </p>
//                   <p>
//                     <strong>Remove:</strong>{" "}
//                     <span>
//                       <i
//                         className="fas fa-trash"
//                         style={{
//                           color: "red",
//                           fontSize: 20,
//                           cursor: "pointer",
//                         }}
//                       ></i>
//                     </span>
//                   </p>
//                 </td>
//               </tr>
//             </tbody>
//           </table>
//         </div>
//               </>
//             )
//           })
//         }
//        </div>
//       </section>
//     </div>
//     </>
//   );
// };

// export default ProductDetails;
