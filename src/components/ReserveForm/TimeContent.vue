<template>
<div class="container mt-2">
    <div class="row">
        
        <div class="col-2">
            <TimeTitle v-bind="titleSetter"/>
        </div>
        <div class="col-10">
            <TimeButtonContent :isMorning="isMorning" v-bind="titleSetter"/>
        </div>
    </div>
</div>
</template>

<script>
import TimeTitle from "./TimeTitle";
import TimeButtonContent from "./TimeButtonContent";
import im1 from '../../assets/img/i1.png'
import im2 from '../../assets/img/i2.png'
export default {
     props:{
          isMorning:{
              type:Boolean,
              default:true
          }  
        },
        computed:{
            titleSetter(){
                if(this.isMorning){
                    return{
                        title:"صبح",
                        srcIcon:im1
                    }
                }else{
                    return{
                        title:"بعد از ظهر",
                        srcIcon:im2
                    }
                }
            }
        },
    components:{
TimeButtonContent,TimeTitle
    },
}
</script>

<style scoped>
div{
    direction: rtl
}

</style>