import React from 'react'
import { useState } from 'react';
import ProductImageService from '../service/ProductImageService';


export default function ProductSpecific() {

  const [img, setImage]= useState(
    ProductImageService.getAllProductImages().then(response=>{setImage(response.data)})
  );


  return (
    <img src="http://localhost:8080/product_images/product_id/3/image_id/1" alt='not found'/>
  )
}
