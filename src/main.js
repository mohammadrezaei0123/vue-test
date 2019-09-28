import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import "./registerServiceWorker";
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import BootstrapVue from 'bootstrap-vue'
import './font-media.css'
import store from './store/store';

Vue.use(BootstrapVue)

window.store=store
Vue.filter('convertEnToFaDig',function (val) {
  let text=val+''
  if (text.length == 0) {
      return "";
  }
  var ns="۰۱۲۳۴۵۶۷۸۹"
  let out = "";
  let length = text.length;
  for (let i = 0; i < length; i++) {
      let c = text.charAt(i);
      let nump=parseInt(c)
      if(nump>=0){
          out+=ns.charAt(nump)
      }else{
          out+=c
      }
  }
  return out
  
})
// Vue.config.productionTip = false;
// Vue.use(VuePersianDatetimePicker, {
//   name: 'custom-date-picker',
//   props: {
//     inputFormat: 'YYYY-MM-DD HH:mm',
//     format: 'jYYYY-jMM-jDD HH:mm',
//     editable: false,
//     inputClass: 'form-control my-custom-class-name',
//     placeholder: 'Please select a date',
//     altFormat: 'YYYY-MM-DD HH:mm',
//     color: '#584443',
//     autoSubmit: false,
//     //...
//     //... And whatever you want to set as default
//     //...
//   }
// });

new Vue({
  store,
  render: h => h(App)
}).$mount("#app");
