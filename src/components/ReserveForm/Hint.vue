<template>
  <div class="d-flex flex-column align-items-end">
      <h6>توصیه‌های پیش از حضور در مرکز</h6>
        <div class="d-flex justify-content-end" v-for="(h,i) in hints" :key="i">
            
            <p class="text-right m-0 p-0">{{h}}</p>
            <i class="arrow-left mt-1 pl-1"></i>
        </div>
  </div>
</template>

<script>
export default {
props:{
    hints:{
        type:Array,
        default:function () {
            return['در زمان مراجعه حتما شماره پیگیری نوبت را به همراه داشته باشید',
                'در صورت عدم مراجعه در زمان مقرر، نوبت شما لغو خواهد شد'
            ]
        }
    }
}
}
</script>
<style scoped>
h6{
  
font-family:IRANSansWeb_Bold !important;
font-size: 0.6rem;
color:#20a8c2;

}
p{
    
font-family:IRANSansWeb_Light !important;
font-size: 0.4rem;
color:#20a8c2;

}
.arrow-left {
  width: 0; 
  height: 0; 
  border-top: 2.5px solid transparent;
  border-bottom: 2.5px solid transparent; 
  
  border-right:4px solid #707070; 
}
</style>