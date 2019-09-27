<template>
<div class="d-flex flex-column content1 py-2 px-3">
  <DoctorCard/>
  <ItemContent/>
</div>
</template>

<script>
import ItemContent from "./ItemContent";
import DoctorCard from "./DoctorCard";

export default {
components:{
ItemContent,DoctorCard
}
}
</script>

<style scoped>
.content1{
  margin :0 20%;
  height: 350px;
}
</style>