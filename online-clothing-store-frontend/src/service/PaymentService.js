import axios from 'axios';
class PaymentService{
    baseurl="http://localhost:8080/payments";

    getAllPayments(){
        return axios.get(this.baseurl)
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