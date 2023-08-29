import axios from 'axios';
class CartService{
    baseurl="http://localhost:8080";

    getAllCarts(){
        return axios.get(this.baseurl+"Cart.json")
    }

    deleteCart(id){
        return axios.delete(this.baseurl+"Cart/"+id+".json")
    }
    addCart(cart){
        return axios.post(this.baseurl+"Cart.json",cart,
        {headers:{'content-type':'application/json'}})
    }
    updateCart(cart){
        console.log("in service update",cart);

        return axios.put(this.baseurl+"Cart/"+cart.id+".json",cart,
        {headers:{'content-type':'application/json'}})
    }

}

export default new CartService();