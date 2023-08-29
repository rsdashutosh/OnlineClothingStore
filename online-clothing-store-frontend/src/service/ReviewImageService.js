import axios from 'axios';
class ReviewImageService{
    baseurl="http://localhost:8080";

    getAllReviewImages(){
        return axios.get(this.baseurl+"ReviewImage.json")
    }

    deleteReviewImage(id){
        return axios.delete(this.baseurl+"ReviewImage/"+id+".json")
    }
    addReviewImage(reviewImage){
        return axios.post(this.baseurl+"ReviewImage.json",reviewImage,
        {headers:{'content-type':'application/json'}})
    }
    updateReviewImage(reviewImage){
        console.log("in service update",reviewImage);

        return axios.put(this.baseurl+"ReviewImage/"+reviewImage.id+".json",reviewImage,
        {headers:{'content-type':'application/json'}})
    }

}

export default new ReviewImageService();