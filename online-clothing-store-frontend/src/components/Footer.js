import React from 'react'

export default function Footer() {
  return (
      <footer class="row row-cols-1 row-cols-sm-2 row-cols-md-5 py-5 my-5 border-top">
      <div class="col-3 mb-3">

      </div>
      <div class="col-3 mb-3 justify-content-center">
        
        <a href="/" id="foot_img" class="d-flex align-items-center mb-3 link-body-emphasis text-decoration-none">
          <img className="ml-5" src={require('../images/icons8-fashion-64.png')} alt='not found'/>
        </a>
        <label for="foot_img">Online Clothing Store</label>
      </div>

      <div class="col-3 mb-3">
        <h5>Men</h5>
        <ul class="nav flex-column">
          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">Shirts</a></li>
          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">Polo Shirts</a></li>
          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">Trousers</a></li>
          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">Shorts</a></li>
        </ul>
      </div>

      <div class="col-3 mb-3">
        <h5>Women</h5>
        <ul class="nav flex-column">
          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">Saree</a></li>
          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">Dress</a></li>
        </ul>
      </div>

      <div class="col-3 mb-3">
        <h5>Kids</h5>
        <ul class="nav flex-column">
          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">Shirt</a></li>
          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">Pants</a></li>
          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">Shorts</a></li>
        </ul>
      </div>
    </footer>
  )
}
