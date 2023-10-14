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

