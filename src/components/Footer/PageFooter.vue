<template>
  <div class="d-flex justify-content-end align-items-center mi w-100 my-1">
      <div class="pr-1">{{title}}</div>
            <i class="left d-flex "></i>

  </div>
</template>

<script>
export default {
    props:{title:String}
}
</script>

<style scoped>
i {
    height: fit-content;
  border: solid #37b9c5;
  border-width: 0 2px 2px 0;
  display: inline-block;
  padding: 2px;
}
div{
      
font-family:IRANSansWeb_Bold !important;
font-size: 0.7rem;
    color:#707381
}

.left {
  transform: rotate(135deg);
  -webkit-transform: rotate(135deg);
}
</style>