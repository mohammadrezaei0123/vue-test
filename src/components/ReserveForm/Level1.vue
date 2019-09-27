<template>
  <div class="container p-0 m-0">
      <div class="row py-2 m-2 mr-3 form-li-blue-border">
          <div class="col">
              <Selector></Selector>
          </div>
        <div class="col d-flex justify-content-end w-100">
            <ArrowTitle title="لطفا بخش مورد نیاز خود را انتخاب کنید"/>
        </div>
      </div>
  </div>
</template>

<script>
import ArrowTitle from "./ArrowTitle";
import Selector from "./Selector";
export default {
components:{
    ArrowTitle,Selector
}
}
</script>

<style scoped>
 
</style>