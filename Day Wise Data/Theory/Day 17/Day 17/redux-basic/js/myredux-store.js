//creating actions
const newBooking =(name,amt)=>{
    /* return {
         type:"NEW_BOOKING",
         payload:{
             name:name,
             amt:amt
         }
     }*/
     return {
         type:"NEW_BOOKING",
         payload:{
             name,
             amt,
         },
     };
 
 };
 const cancelBooking =(name,refundamt)=>{
     /* return {
          type:"NEW_BOOKING",
          payload:{
              name:name,
              amt:amt
          }
      }*/
      return {
          type:"CANCEL_BOOKING",
          payload:{
              name,
              refundamt
          }
      };
  
  };
//define reducers

// these are the functions which will accept actions when they are dispatched and they handle the action
const reservationHistory=(oldReservationList=[],action)=>{
    console.log("in reservation history")
  switch(action.type){
      case "NEW_BOOKING":
          return [...oldReservationList,action.payload]
          break;
      case "CANCEL_BOOKING":
          return oldReservationList.filter(record=>{
              return record.name !== action.payload.name;
          })
          break;
       default :
          return oldReservationList;   
  }
};

const cancellationHistory=(oldCancellationList=[],action)=>{
    console.log("in rcancellation history")
    if(action.type=="CANCEL_BOOKING"){
    return [...oldCancellationList,action.payload];
    }
    return oldCancellationList;
  };

 const accounting=(totalMoney=100 , action)=>{ 
    if(action.type=="NEW_BOOKING"){
        console.log("in accountiong")
        console.log(action);
        return totalMoney+action.payload.amt;
        }
    else if(action.type=="CANCEL_BOOKING"){
    return totalMoney-action.payload.refundamt;
    }
    return totalMoney;
  };
//define state
console.log(Redux);
const {createStore,combineReducers} =Redux;
 const railwayStore =combineReducers({
    accounting:accounting,
    reservationHistory:reservationHistory,
    cancellationHistory : cancellationHistory
}); 
const store =createStore(railwayStore)

//create store

const action=newBooking("Rajan",20);
store.dispatch(action);
console.log(store.getState())
const action1=newBooking("Revati",40);
store.dispatch(action1);
console.log(store.getState())
const action2=cancelBooking("Revati",25);
store.dispatch(action2);
console.log(store.getState())