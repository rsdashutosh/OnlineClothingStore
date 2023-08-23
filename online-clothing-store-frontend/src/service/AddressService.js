import axios from 'axios';
class AddressService{
    baseurl="https://localhost:8080";

    getAllAddresss(){
        return axios.get(this.baseurl+"Address.json")
    }

    deleteAddress(id){
        return axios.delete(this.baseurl+"Address/"+id+".json")
    }
    addAddress(address){
        return axios.post(this.baseurl+"Address.json",address,
        {headers:{'content-type':'application/json'}})
    }
    updateAddress(address){
        console.log("in service update",address);

        return axios.put(this.baseurl+"Address/"+address.id+".json",address,
        {headers:{'content-type':'application/json'}})
    }

}

export default new AddressService();