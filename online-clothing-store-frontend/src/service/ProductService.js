import axios from 'axios';
class ProductService{

    baseurl="http://localhost:8080/products";

    getAllProducts(){
        return axios.get(this.baseurl)
    }

    getProductsByCategory(cat){
        return axios.get(this.baseurl+"/category", {
            params: {
             category: cat
            }
          });
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