<template>
  <div class="container">
      <div class="row">
          <div class="d-flex flex-column  mx-auto ">
              <span>نوبت ها</span>
              <span>{{month}}</span>
          </div>
      </div>
      <div class="row">
          <div class="col-12">
              <div class="container-fluid position-relative no-gutters">
              <div class="bords my-1"></div>
                  <div class="row no-gutters ">
                      <div class="col pt-3 head">ج</div>
                      <div class="col pt-3 head">پ</div>
                      <div class="col pt-3 head">چ</div>
                      <div class="col pt-3 head">س</div>
                      <div class="col pt-3 head">د</div>
                      <div class="col pt-3 head">ی</div>
                      <div class="col pt-3 head">ش</div>
                  </div>
                  <div class="row no-gutters">
                      <div class="col pt-3 j">{{4|convertEnToFaDig}}</div>
                      <div class="col pt-3">{{3|convertEnToFaDig}}</div>
                      <div class="col pt-3">{{2|convertEnToFaDig}}</div>
                      <div class="col pt-3">{{1|convertEnToFaDig}}</div>
                      <div class="col pt-3"> </div>
                      <div class="col pt-3"> </div>
                      <div class="col pt-3"> </div>
                  </div>
                  <div class="row no-gutters">
                      <div class="col pt-3 j">{{11|convertEnToFaDig}}</div>
                      <div class="col pt-3">{{10|convertEnToFaDig}}</div>
                      <div class="col pt-3">{{9|convertEnToFaDig}}</div>
                      <div class="col pt-3">{{8|convertEnToFaDig}}</div>
                      <div class="col pt-3">{{7|convertEnToFaDig}}</div>
                      <div class="col pt-3">{{6|convertEnToFaDig}}</div>
                      <div class="col pt-3">{{5|convertEnToFaDig}}</div>
                  </div>
                  <div class="row no-gutters">
                      <div class="col pt-3 j">{{19|convertEnToFaDig}}</div>
                      <div class="col pt-3">{{18|convertEnToFaDig}}</div>
                      <div class="col pt-3">{{17|convertEnToFaDig}}</div>
                      <div class="col pt-3">{{16|convertEnToFaDig}}</div>
                      <div class="col pt-3">{{15|convertEnToFaDig}}</div>
                      <div class="col pt-3">{{14|convertEnToFaDig}}</div>
                      <div class="col pt-3">{{13|convertEnToFaDig}}</div>
                  </div>
                  <div class="row no-gutters">
                      <div class="col def pt-3 j">{{26|convertEnToFaDig}}</div>
                      <div class="col def pt-3">{{25|convertEnToFaDig}}</div>
                      <div class="col def pt-3">{{24|convertEnToFaDig}}</div>
                      <div class="col sel pt-3">{{23|convertEnToFaDig}}</div>
                      <div class="col pt-3">{{22|convertEnToFaDig}}</div>
                      <div class="col pt-3">{{21|convertEnToFaDig}}</div>
                      <div class="col pt-3">{{20|convertEnToFaDig}}</div>
                  </div>
                  <div class="row no-gutters">
                      <div class="col def pt-3"> </div>
                      <div class="col def pt-3"> </div>
                      <div class="col def pt-3">{{31|convertEnToFaDig}}</div>
                      <div class="col def pt-3">{{30|convertEnToFaDig}}</div>
                      <div class="col def pt-3">{{29|convertEnToFaDig}}</div>
                      <div class="col def pt-3">{{28|convertEnToFaDig}}</div>
                      <div class="col def pt-3">{{27|convertEnToFaDig}}</div>
                  </div>
              </div>
          </div>
      </div>
  </div>
</template>

<script>
export default {
data(){
    return{
        month:"< شهریور >"
    }
}
}
</script>

<style scoped>
.bords{
    
    background-image: linear-gradient(45deg,#fff,#5ec7d1,#fff);
    position: absolute;
    top: 0;
    left: 50%;
    transform: translateX(-50%);
    width: 50%;
    height: 3px;
}
.col{
      
font-family:IRANSansWeb !important;
font-size: 0.5rem;
color:#e6d8d9;
}
.def{
    color:#707381
}
.head{
    
color:#5ec7d1;
}
span{
  
font-family:IRANSansWeb_Bold !important;
font-size: 0.6rem;
color:#5ec7d1;
}
</style>