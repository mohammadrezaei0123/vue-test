<template>
<div class="d-flex flex-wrap">
    <TimeButton v-for="(v,i) in btValue" :key="i" :index="i" :isMorning="isMorning" :time="v" :tTime="title"/>
    <!-- <TimeButton :tTime="title"/>
    <TimeButton :tTime="title"/>
    <TimeButton :tTime="title" :isActive="true"/>
    <TimeButton :tTime="title"/>
    <TimeButton :tTime="title"/>
    <TimeButton :tTime="title"/>
    <TimeButton :tTime="title"/> -->
</div>
</template>

<script>
import TimeButton from "./TimeButton";
export default {
    
    props:["title","srcIcon","isMorning"],
    components:{
TimeButton
    },
    computed:{
        btValue(){
            if(this.isMorning){
                return this.$store.state.morningTime
            }else{
                return this.$store.state.afternoneTime
            }
        }
    }
}
</script>

<style scoped>
div{
    direction: rtl
}

</style>