import './App.css';
import {Routes,Route,Navigate} from 'react-router-dom'
import Admin from './pages/AdminDashboard';
import Login from './pages/Login';
import Register from './pages/Register';
import Cart from './pages/Cart';
import Checkout from './pages/Checkout';
import Home from './pages/Home';
import OrderHistory from './pages/OrderHistory';
import UserProfile from './pages/UserProfile';
import Wishlist from './pages/Wishlist';
import Products from './pages/Products';
import ProductSpecific from './pages/ProductSpecific';
import Header from './components/Header';
import Footer from './components/Footer';
import 'bootstrap/dist/css/bootstrap.min.css';
import MyNavbar from './components/Navbar';
import ProductSearch from './pages/ProductSearch';

function App() {
  return (
    <div className="App">
      <Header/>
        <Routes>
          <Route path="/" element={<Navigate replace to="/login"/>}></Route>
          <Route path="/admin" element={<Admin/>}></Route>
          <Route path="/login" element={<Login/>}></Route>
          <Route path="/register" element={<Register/>}></Route>
          <Route path="/cart" element={<Cart/>}></Route>
          <Route path="/checkout" element={<Checkout/>}></Route>
          <Route path="/home" element={<Home/>}></Route>
          <Route path="/orders" element={<OrderHistory/>}></Route>
          <Route path="/profile" element={<UserProfile/>}></Route>
          <Route path="/wishlist" element={<Wishlist/>}></Route>
          <Route path="/product" element={<Products/>}></Route>
          <Route path="/product_search" element={<ProductSearch/>}></Route>
          <Route path="/productspecific" element={<ProductSpecific/>}></Route>
          
        </Routes>
      <Footer/>
    </div>
    
  );
}

export default App;
