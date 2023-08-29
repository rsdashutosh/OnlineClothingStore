import axios from 'axios';
class ShippingService{
    baseurl="http://localhost:8080";

    getAllShippings(){
        return axios.get(this.baseurl+"Shipping.json")
    }

    deleteShipping(id){
        return axios.delete(this.baseurl+"Shipping/"+id+".json")
    }
    addShipping(shipping){
        return axios.post(this.baseurl+"Shipping.json",shipping,
        {headers:{'content-type':'application/json'}})
    }
    updateShipping(shipping){
        console.log("in service update",shipping);

        return axios.put(this.baseurl+"Shipping/"+shipping.id+".json",shipping,
        {headers:{'content-type':'application/json'}})
    }

}

export default new ShippingService();