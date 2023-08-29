import axios from 'axios';

class UserService{
    baseurl="http://localhost:8080/users";

    getAllUsers(){
        return axios.get(this.baseurl)
    }

    userAuth(email,password){
        var response=axios.get("/login/"+email+"/"+password)
        return response;
    }

    deleteUser(id){
        return axios.delete(this.baseurl+"User/"+id+".json")
    }
    addUser(user){
        return axios.post(this.baseurl+"User.json",user,
        {headers:{'content-type':'application/json'}})
    }
    updateUser(user){
        console.log("in service update",user);

        return axios.put(this.baseurl+"User/"+user.id+".json",user,
        {headers:{'content-type':'application/json'}})
    }

}


export default new UserService();