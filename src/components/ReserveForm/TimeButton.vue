<template>
  <button type="button" :class="butClass">{{time|convertEnToFaDig}} {{tTime}}</button>
</template>

<script>
export default {
    props:{
        isActive:{
            type:Boolean,
            default:false
        },
        time:{
            type:String,
            default:"19:00"
        },tTime:{
            type:String,
            default:"بعد از ضهر"
        }
    },
    computed:{
        butClass(){
            return (this.isActive)?"mr-1 mb-1 btn btn-info btn-sm":"mr-1 mb-1 btn btn-light btn-sm"
        }
    }
}
</script>

<style scoped>
button{
    
    max-height: 1.5rem;
    min-width: 3rem;
font-family:IRANSansWeb_bold !important;
font-size: 0.6rem;
}
</style>