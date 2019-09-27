<template>
<div :style="(isActive)?'box-shadow: 0 2px 8px 0 #dbeff6;':''" class="d-flex flex-column content p-2 back justify-content-between align-items-center" >
<div class="content-shape">
    <img :src="srcIcon" >
    <!-- <div class="rect">
        <img src="../../assets/img/logo.png" >
    </div> -->
    </div>
  <p class="pt-1">{{title}}</p>
</div>
</template>

<script>
export default {
    props:{
        title:String,srcIcon:String,
        isActive:{
            type:Boolean,
            default:false
        }
    }
    

}
</script>

<style scoped>
/* .content{ */
    /* width: 4rem;
    height: 4rem; */
/* } */
p{
    
  font-weight: bold;
font-family:IRANSansWeb_Bold !important;
font-size: 0.6rem;
white-space: nowrap;
color: #4494ad;
}
.back{
    width:5rem;
    height:5rem
}
.content-shape{
    position: relative;
    background:url("../../assets/img/rect.png");
    background-size:cover;
}
img{
    padding:0.8rem;
    
    width: 3rem;
    height: 3rem;
}
.rect{
    position: absolute;
    /* margin-top:1rem; */
    transform: rotate(45deg);
    width: 2rem;
    height: 2rem;
    background: yellow;
}
</style>