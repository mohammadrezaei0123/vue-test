<template>
  <div class="d-flex justify-content-between">
      <div>
  <b-dropdown size="sm" :style="'height:fit-content !important'"  variant="link" toggle-class="text-decoration-none" no-caret>
    <template v-slot:button-content>
      <i class="arrow-down mt-1"></i>
      <!-- &#x1f50d;<span class="sr-only">Search</span> -->
    </template>
    <b-dropdown-item @click="cil"  v-for="(v,i) in doc" :key="i" href="#">
      <h6 class="my-1" style="text-align:right;">{{v}}</h6>
    </b-dropdown-item>
    <!-- <b-dropdown-item href="#">Action</b-dropdown-item>
    <b-dropdown-item href="#">Another action</b-dropdown-item>
    <b-dropdown-item href="#">Something else here...</b-dropdown-item> -->
  </b-dropdown>
</div>
      <!-- <i class="arrow-down mt-1"></i> -->
      <!-- <b-dropdown id="dropdown-left" text="" variant="transparent" class="mt-n1 p-0">
    <b-dropdown-item v-for="(v,i) in doc" :key="i" href="#">
      <h6>{{v}}</h6>
    </b-dropdown-item>
  </b-dropdown> -->
      <div class="d-flex">
          <div class="d-flex flex-column pr-1">
              <h6>انتخاب بخش</h6>
              <span>{{selectedData}}</span>
          </div>
          <img src="../../assets/img/chart.png" class="mt-1" alt="" srcset="">
      </div>
  </div>
</template>

<script>
export default {
  methods:{
    cil(e){
      // console.log(e.target.innerText)
      this.selectedData=e.target.innerText
    }
  },
data(){
  return{
    selectedData:"مشاوره قلب",
    doc:[
      "مشاوره قلب",
      'داخلی'
    ]
  }
}
}
</script>

<style scoped>
h6{
  
font-family:IRANSansWeb_bold !important;
font-size: 0.7rem;
color:#707381;
}
span{
  
font-family:IRANSansWeb_light !important;
font-size: 0.5rem;
color:#e6d8d9;
}
img{
    width: 0.6rem;
    height: 0.6rem;
}
.arrow-down {
  width: 0; 
  height: 0; 
  border-left: 0.4rem solid transparent;
  border-right: 0.4rem solid transparent;
  
  border-top: 0.5rem solid #05a8b7;
}

</style>