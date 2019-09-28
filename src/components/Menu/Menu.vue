<template>
<nav :class='"navbar navbar-expand-lg navbar-dark  px-3  fixed-top"+classSeter'>
    <div class="container-fluid m-0 p-0 bg-transparent">
        <div class="col-2 d-flex justify-content-center align-items-center">
<button type="button" class="btn  btn-info l btn-sm px-3 text-nowrap">ثبت نام</button>
<button type="button" class="btn btn-transparent btn-sm v">ورود</button>
        </div>
        <div class="col-6 offset-1 bg-transparent  d-flex flex-row-revrese justify-content-around flex-nowrap">
          <MenuItem  value="خانه"/>
          <MenuItem  value="خدمات ما"/>
          <MenuItem  value="اخبار و مقالات"/>
          <MenuItem  value="همایش‌ها"/>
          <MenuItem  value="درباره ما"/>
          <MenuItem  value="تماس با ما"/>
        </div>
        <div class="col-3 ">
        <img src="../../assets/img/logo.png" >
        </div>
    </div>
    
</nav>
</template>

<script>
import MenuItem from "./MenuItem";
export default {
  destroyed(){
    window.removeEventListener('scroll',this.scroll)
  },
  methods:{
    scroll(){
    var doc = document.documentElement;
            // var lefta = (window.pageXOffset || doc.scrollLeft) - (doc.clientLeft || 0);
            var newTop =((window.pageYOffset || doc.scrollTop)  - (doc.clientTop || 0));
            console.log(newTop)
            if(newTop>5){
              this.$el.style.boxShadow="2px 4px 8px 0 #dbeff6"
              this.isTop=false
              // this.$el.style.backgroundColor='#fff'
              // this.$el.style.borderRadius="5px"
              
              // this.$el.style.border="none"
              // this.$el.style.paddingTop='1rem'
            }else{
              this.$el.style.boxShadow="none"
              this.isTop=true
              // this.$el.style.backgroundColor='transparent'
              
              // this.$el.style.border="border-bottom: 1px solid #dbe0e2"
              
              // this.$el.style.borderRadius="0"
              // this.$el.style.padding='0'
            }
  }
  },
  mounted(){
    this.scroll()
    // console.log(this.$el.offsetHeight)
    // document.getElementById("app").style.paddingTop=this.$el.offsetHeight+"px"
    // document.getElementById("sti").style.marginTop=this.$el.offsetHeight+"px"
    // console.dir(document.querySelector("#tops"))
    document.querySelector("#tops").style.marginTop="-"+this.$el.offsetHeight+"px"
    window.addEventListener("scroll",this.scroll)
  },
  components:{
    MenuItem
  },data(){
    return{
      isTop:true
    }
  },computed:{
    classSeter(){
      return (this.isTop)?"bg-transparent py-4":" bg-light py-0"
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
nav{
  transition: all 2s;
}
.btn{
  
font-family:IRANSansWeb !important;
font-size: 0.70rem;
}
.v{
  color: #26b3c7;
}
.mn{
color: #51badc;
}
.l{
  
    background-image: linear-gradient(45deg,#20abc2,  #14c8d1);
    max-height: 2rem;
    border-radius: 12px
}
img{
  max-width: 40px;
  max-height: 40px;
}
</style>
