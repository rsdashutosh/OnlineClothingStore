import axios from 'axios';
class PaymentService{
    baseurl="https://reactfirst-66a03-default-rtdb.firebaseio.com/";

    getAllPayments(){
        return axios.get(this.baseurl+"Payment.json")
    }

    deletePayment(id){
        return axios.delete(this.baseurl+"Payment/"+id+".json")
    }
    addPayment(payment){
        return axios.post(this.baseurl+"Payment.json",payment,
        {headers:{'content-type':'application/json'}})
    }
    updatePayment(payment){
        console.log("in service update",payment);

        return axios.put(this.baseurl+"Payment/"+payment.id+".json",payment,
        {headers:{'content-type':'application/json'}})
    }

}

export default new PaymentService();