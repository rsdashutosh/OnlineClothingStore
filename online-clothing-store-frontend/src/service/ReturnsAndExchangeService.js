import axios from 'axios';
class ReturnAndExchangeService{
    baseurl="http://localhost:8080";

    getAllReturnAndExchanges(){
        return axios.get(this.baseurl+"ReturnAndExchange.json")
    }

    deleteReturnAndExchange(id){
        return axios.delete(this.baseurl+"ReturnAndExchange/"+id+".json")
    }
    addReturnAndExchange(returnsAndExchange){
        return axios.post(this.baseurl+"ReturnAndExchange.json",returnsAndExchange,
        {headers:{'content-type':'application/json'}})
    }
    updateReturnAndExchange(returnsAndExchange){
        console.log("in service update",returnsAndExchange);

        return axios.put(this.baseurl+"ReturnAndExchange/"+returnsAndExchange.id+".json",returnsAndExchange,
        {headers:{'content-type':'application/json'}})
    }

}

export default new ReturnAndExchangeService();