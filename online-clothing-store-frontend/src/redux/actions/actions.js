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


export const ADD_TO_FETCHED_PRODUCTS = (id) =>{
  return{
      type : "ADD_TO_FETCHED_PRODUCTS",
      payload : id
  }
}