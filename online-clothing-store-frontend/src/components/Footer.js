import { Link } from "react-router-dom"
import "./Footer.css"

const Footer=()=>{
    
    return(
        <div className="footer bg-dark text-light p-3">

            <h6 className="text-center"> &copy; www.onlineshopping.com All rights reserved </h6>
            <p className="text-center mt-3"> 
            <Link to="/about">About </Link> |
            <Link to="/contact">Contact Us </Link> |
            <Link to="/policy">Privacy Policy </Link>
            </p>

        </div>
    )
}

export default Footer;