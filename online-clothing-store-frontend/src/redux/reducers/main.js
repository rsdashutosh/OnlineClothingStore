import {combineReducers} from "redux";
import { cartreducer } from "./reducer";
import { loggedReducer } from "./reducer";
import { searchReducer } from "./reducer";

const rootreducer = combineReducers({
    cartreducer,
    loggedReducer,
    searchReducer
});

export default rootreducer