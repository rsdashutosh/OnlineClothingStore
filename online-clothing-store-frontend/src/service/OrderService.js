import axios from 'axios';
class OrderService{
    baseurl="http://localhost:8080/orders";

    getAllOrders(){
        return axios.get(this.baseurl)
    }

    getAllOrdersOfACustomer(userId){
        return axios.get(this.baseurl+"/user_id/"+userId)
    }

    deleteOrder(id){
        return axios.delete(this.baseurl+"Order/"+id+".json")
    }

    addOrder(order){
        return axios.post(this.baseurl+"Order.json",order,
        {headers:{'content-type':'application/json'}})
    }

    addOrdersFromCart(orderDetails){
        return axios.post(this.baseurl+"/cart",orderDetails,{headers:{'content-type':'application/json'}})
    }

    updateOrder(order){
        console.log("in service update",order);

        return axios.put(this.baseurl+"Order/"+order.id+".json",order,
        {headers:{'content-type':'application/json'}})
    }

}

export default new OrderService();