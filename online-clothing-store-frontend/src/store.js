 import { createStore } from 'redux';
 import rootreducer from './redux/reducers/main';

 const store = createStore(rootreducer,
    window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__());

 export default store;