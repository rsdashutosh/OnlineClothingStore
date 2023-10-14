import {combineReducers} from "redux";
import { cartreducer } from "./reducer";
import { loggedReducer } from "./reducer";
import { searchReducer } from "./reducer";
import { orderReducer } from "./reducer";
import { userReducer } from "./reducer";

const rootreducer = combineReducers({
    cartreducer,
    loggedReducer,
    searchReducer,
    orderReducer,
    userReducer
});

export default rootreducer