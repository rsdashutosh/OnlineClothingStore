import axios from 'axios';
class OfferService{
    baseurl="http://localhost:8080";

    getAllOffers(){
        return axios.get(this.baseurl+"Offer.json")
    }

    deleteOffer(id){
        return axios.delete(this.baseurl+"Offer/"+id+".json")
    }
    addOffer(offer){
        return axios.post(this.baseurl+"Offer.json",offer,
        {headers:{'content-type':'application/json'}})
    }
    updateOffer(offer){
        console.log("in service update",offer);

        return axios.put(this.baseurl+"Offer/"+offer.id+".json",offer,
        {headers:{'content-type':'application/json'}})
    }

}

export default new OfferService();