import axios from 'axios';
class ProductImageService{
    baseurl="http://localhost:8080";

    

    getAllProductImages(){
        return axios.get(this.baseurl+"/product_images/product_id/3/image_id/1")
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