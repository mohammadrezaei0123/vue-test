import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)
const store = new Vuex.Store({
    state: {
        morningTime:["11:00","12:00","08:00"],
        afternoneTime:["08:00","09:00","10:00"],
        chooseValue:{
            isMorning:true,
            chooseIndex:0
        }
    },
    getters:{
        printChooseValue: state => {
            if(state.chooseValue.isMorning){
                return state.morningTime[state.chooseValue.chooseIndex]+' صبح'
            }else{
                return state.afternoneTime[state.chooseValue.chooseIndex]+' بعد از ظهر'
            }
          }
    },
    mutations: {
      setTimming:(state,payload)=>{
        state.chooseValue=payload
      }
    },
    actions: {
        setTimming ({ commit },value) {
            commit('setTimming',value)
      }
    }
  })

  export default store;