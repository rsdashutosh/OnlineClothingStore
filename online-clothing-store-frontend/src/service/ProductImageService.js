import axios from 'axios';
class ProductImageService{
    baseurl="https://reactfirst-66a03-default-rtdb.firebaseio.com/";

    getAllProductImages(){
        return axios.get(this.baseurl+"ProductImage.json")
    }

    deleteProductImage(id){
        return axios.delete(this.baseurl+"ProductImage/"+id+".json")
    }
    addProductImage(productImage){
        return axios.post(this.baseurl+"ProductImage.json",productImage,
        {headers:{'content-type':'application/json'}})
    }
    updateProductImage(productImage){
        console.log("in service update",productImage);

        return axios.put(this.baseurl+"ProductImage/"+productImage.id+".json",productImage,
        {headers:{'content-type':'application/json'}})
    }

}

export default new ProductImageService();