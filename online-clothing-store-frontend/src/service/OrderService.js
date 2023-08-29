import axios from 'axios';
class OrderService{
    baseurl="http://localhost:8080/orders";

    getAllOrders(){
        return axios.get(this.baseurl)
    }

    getAllOrdersOfACustomer(){
        return axios.get(this.baseurl)
    }

    deleteOrder(id){
        return axios.delete(this.baseurl+"Order/"+id+".json")
    }
    addOrder(order){
        return axios.post(this.baseurl+"Order.json",order,
        {headers:{'content-type':'application/json'}})
    }
    updateOrder(order){
        console.log("in service update",order);

        return axios.put(this.baseurl+"Order/"+order.id+".json",order,
        {headers:{'content-type':'application/json'}})
    }

}

export default new OrderService();