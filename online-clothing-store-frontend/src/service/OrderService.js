import axios from 'axios';
class OrderService{
    baseurl="https://reactfirst-66a03-default-rtdb.firebaseio.com/";

    getAllOrders(){
        return axios.get(this.baseurl+"Order.json")
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