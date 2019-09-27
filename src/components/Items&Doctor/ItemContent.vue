<template>
<div class="d-flex justify-content-around h-50">

<Item title="پرسش و پاسخ" :srcIcon="comment"/>

<Item title="مقالات علمی" :srcIcon="sa"/>

<Item title="دوره‌های آموزشی" :srcIcon="video"/>

<Item title="موقعیت مطب" :srcIcon="loaction" :isActive="true"/>

<Item title="دریافت نوبت" :srcIcon="reserve"/>
</div>
  
</template>

<script>
import Item from "./Item1";
import img5 from '../../assets/img/location.png'
import img4 from '../../assets/img/comment.png'
import img3 from '../../assets/img/video.png'
import img2 from '../../assets/img/sa.png'
import img1 from '../../assets/img/reserve.png'

export default {
components:{
Item
},
data(){
    return{
        sa:img2,
        reserve:img1,
        video:img3,
        comment:img4,
        loaction:img5
    }
}
}
</script>

<style scoped>

</style>