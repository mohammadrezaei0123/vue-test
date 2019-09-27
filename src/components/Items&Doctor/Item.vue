<template>
<div class="d-flex flex-column content bg-danger justify-content-between align-items-center">
<div class="content-shape">
    <div class="rect">
        <img src="../../assets/img/logo.png" >
    </div>
    </div>
  <p>{{title}}</p>
</div>
</template>

<script>
export default {
    props:["title"]

}
</script>

<style scoped>
/* .content{ */
    /* width: 4rem;
    height: 4rem; */
/* } */
.content-shape{
    position: relative;
    width: 3rem;
    height: 3rem;
}
img{
    width: 100%;
    height: 100%;
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