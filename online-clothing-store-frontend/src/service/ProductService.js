import axios from 'axios';
class ProductService{
    baseurl="https://reactfirst-66a03-default-rtdb.firebaseio.com/";

    getAllProducts(){
        return axios.get(this.baseurl+"Product.json")
    }

    deleteProduct(id){
        return axios.delete(this.baseurl+"Product/"+id+".json")
    }
    addProduct(product){
        return axios.post(this.baseurl+"Product.json",product,
        {headers:{'content-type':'application/json'}})
    }
    updateProduct(product){
        console.log("in service update",product);

        return axios.put(this.baseurl+"Product/"+product.id+".json",product,
        {headers:{'content-type':'application/json'}})
    }

}

export default new ProductService();