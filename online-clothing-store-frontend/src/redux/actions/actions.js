// for user login check
export const LOGIN = (x) =>{
  return{
      type : "LOGIN",
      payload : x
  }
}

export const LOGOUT = (x) =>{
  return{
      type : "LOGOUT",
      payload : x
  }
}



// for cart
export const ADD = (item) =>{
  return{
      type : "ADD_CART",
      payload : item
  }
}

export const DELETE = (id) =>{
  return{
      type : "REMOVE_CART",
      payload : id
  }
}

export const WISHLIST = (id) =>{
  return{
      type : "WISHLIST_ITEM",
      payload : id
  }
}

export const MOVE_TO_CART = (id) =>{
  return{
      type : "MOVE_TO_CART",
      payload : id
  }
}

export const REMOVE_FROM_WISHLIST = (id) =>{
  return{
      type : "REMOVE_FROM_WISHLIST",
      payload : id
  }
}


export const SEARCH_RESULT = (products) =>{
  return{
      type : "SEARCH_RESULT",
      payload : products
  }
}


// for storing fetched orders of a user
export const STORE_ORDERS = (orders) =>{
  return{
      type : "STORE_ORDERS",
      payload : orders
  }
}

export const FETCH_ORDERS = () =>{
  return{
      type : "FETCH_ORDERS",
      //payload : orders
  }
}


// for user id
export const STORE_USER_ID = (user_id) =>{
  return{
      type : "STORE_USER_ID",
      payload : user_id
  }
}

export const FETCH_USER_ID = () =>{
  return{
      type : "FETCH_USER_ID",
      //payload : orders
  }
}

// for user
export const STORE_USER = (user_details) =>{
  return{
      type : "STORE_USER",
      payload : user_details
  }
}

export const FETCH_USER = () =>{
  return{
      type : "FETCH_USER",
      //payload : orders
  }
}

