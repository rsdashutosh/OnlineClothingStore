import axios from 'axios';

class UserService{
    baseurl="http://localhost:8080/users";

    getAllUsers(){
        return axios.get(this.baseurl)
    }

    getUserDetails(userId){
        return axios.get(this.baseurl+"/user_id/"+userId)
    }

    userAuth(user){
        return axios.post(this.baseurl+"/login",user,
            {headers:{'content-type':'application/json'}})
    }

    deleteUser(id){
        return axios.delete(this.baseurl+"/User/"+id+".json")
    }

    addUser(user){
        return axios.post(this.baseurl,user,{headers:{'content-type':'application/json'}})
    }

    updateUser(user){
        console.log("in service update",user);

        return axios.put(this.baseurl+"User/"+user.id+".json",user,
        {headers:{'content-type':'application/json'}})
    }

}


export default new UserService();