import axios from 'axios';
class WishlistService{
    baseurl="https://reactfirst-66a03-default-rtdb.firebaseio.com/";

    getWishlist(){
        return axios.get(this.baseurl)
    }

    deleteWishlist(id){
        return axios.delete(this.baseurl+"Wishlist/"+id+".json")
    }
    addWishlist(wishlist){
        return axios.post(this.baseurl+"Wishlist.json",wishlist,
        {headers:{'content-type':'application/json'}})
    }
    updateWishlist(wishlist){
        console.log("in service update",wishlist);

        return axios.put(this.baseurl+"Wishlist/"+wishlist.id+".json",wishlist,
        {headers:{'content-type':'application/json'}})
    }

}

export default new WishlistService();