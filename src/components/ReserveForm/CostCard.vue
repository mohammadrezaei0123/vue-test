<template>
  <div class="d-flex flex-column align-items-end">
      <div class="d-flex align-items-center"><p class="pr-2 pt-2 c h-100 d-flex align-items-center">{{cost|convertEnToFaDig|reail}}</p>
      
      <h6 class="h-100 d-flex align-items-center">:هزینه‌ی قابل پرداخت</h6>
      </div>
      <div class="d-flex align-items-center mb-4">
          <div class="d-flex align-items-center">{{txstIsEnable}}</div>
          <SwitchButton color="#20a8c2" class="px-1"/>
          <h6 class="m-0 p-0">به صورت اینترنتی پرداخت میکنید</h6>
      </div>
  </div>
</template>

<script>
import SwitchButton from "./SwitchButton";
export default {
    components:{
        SwitchButton
    },
    filters:{
        reail(val){
            let b=true
            let re=''
            while (b) {
                let le=val.length
                if(le-3>0){
                    re=","+val.slice(le-3, le)+re;
                }else{
                    re=val.slice(0, le)+re;
                    b=false;
                }
                
                val=val.slice(0, le-3);
            }
            return " "+re+" "+"ریال"
        }
    },
props:['cost'],
data(){
    return{
        isEnable:false
    }
},
computed:{
    txstIsEnable(){
        return (this.isEnable)?"بله":"خیر"
    }
}
}
</script>

<style scoped>
p{
    font-family:IRANSansWeb_Bold !important;
font-size: 0.66rem;
}
h6,div{
  
font-family:IRANSansWeb !important;
font-size: 0.6rem;
color:mediumturquoise;
}
div{
  
font-family:IRANSansWeb_Bold !important;
font-size: 0.6rem;
color:#20a8c2;
}
p{
    direction: rtl
}
</style>