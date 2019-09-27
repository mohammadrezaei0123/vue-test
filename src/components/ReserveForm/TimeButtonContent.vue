<template>
<div class="d-flex flex-wrap">
    <TimeButton :tTime="title"/>
    <TimeButton :tTime="title"/>
    <TimeButton :tTime="title"/>
    <TimeButton :tTime="title" :isActive="true"/>
    <TimeButton :tTime="title"/>
    <TimeButton :tTime="title"/>
    <TimeButton :tTime="title"/>
    <TimeButton :tTime="title"/>
</div>
</template>

<script>
import TimeButton from "./TimeButton";
export default {
    
    props:["title","srcIcon"],
    components:{
       
TimeButton
    },
}
</script>

<style scoped>
div{
    direction: rtl
}

</style>