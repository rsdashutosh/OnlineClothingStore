import axios from 'axios';
class ReviewService{
    baseurl="http://localhost:8080";

    getAllReviews(){
        return axios.get(this.baseurl+"Review.json")
    }

    deleteReview(id){
        return axios.delete(this.baseurl+"Review/"+id+".json")
    }
    addReview(review){
        return axios.post(this.baseurl+"Review.json",review,
        {headers:{'content-type':'application/json'}})
    }
    updateReview(review){
        console.log("in service update",review);

        return axios.put(this.baseurl+"Review/"+review.id+".json",review,
        {headers:{'content-type':'application/json'}})
    }

}

export default new ReviewService();