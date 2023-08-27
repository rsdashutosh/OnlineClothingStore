//import logo from './logo.svg';
import './App.css';
import Login from './pages/Login';
import Registration from './pages/Registration';
import Home from './pages/Home';
import Cart from './pages/Cart';
import Checkout from './pages/Checkout';
import OrderHistory from './pages/OrderHistory';
import Coupon from './pages/Coupon';
import AdminDashboard from './pages/AdminDashboard';
import ProductSearch from './pages/ProductSearch';
import Product from './pages/Product';
import UserProfile from './pages/UserProfile';
import Wishlist from './pages/Wishlist';
import {Routes,Route,Navigate} from 'react-router-dom'
import 'bootstrap/dist/css/bootstrap.min.css';
import Header from './components/Header';

function App() {
  return (
    
    <div className="App">
      <Header/>
      <Routes>
        <Route path="/" element={<Navigate replace to="/home"/>}></Route>
        <Route path="/admin" element={<AdminDashboard/>}></Route>
        <Route path="/login" element={<Login/>}></Route>
        <Route path="/register" element={<Registration/>}></Route>
        <Route path="/cart" element={<Cart/>}></Route>
        <Route path="/checkout" element={<Checkout/>}></Route>
        <Route path="/coupon" element={<Coupon/>}></Route>
        <Route path="/home" element={<Home/>}></Route>
        <Route path="/orders" element={<OrderHistory/>}></Route>
        <Route path="/profile" element={<UserProfile/>}></Route>
        <Route path="/wishlist" element={<Wishlist/>}></Route>
        <Route path="/product" element={<ProductSearch/>}>
        <Route path=":pid" element={<Product/>}></Route>
        
        </Route>
        <Route path='/productdtls/:id' element={<ProductDetails/>}></Route>
      </Routes>
    </div>
  );
}

export default App;
