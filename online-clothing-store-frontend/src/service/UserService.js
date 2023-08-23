import axios from 'axios';
class UserService{
    baseurl="https://reactfirst-66a03-default-rtdb.firebaseio.com/";

    getAllUsers(){
        return axios.get(this.baseurl+"User.json")
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