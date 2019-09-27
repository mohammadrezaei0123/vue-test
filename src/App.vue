<template>
  <div id="app" >
    
    <div class="top-shape"></div>
    <Menu></Menu>
    <InfoContent></InfoContent>
    <MidContent/>
    <FormContent/>
    <FooterContent/>
  </div>
</template>

<script>

  import Menu from "@/components/Menu/Menu";
  import InfoContent from "./components/DoctorInfo/InfoContent";
  import FormContent from './components/ReserveForm/FormContent'
  import RectDotted from './components/Shape/RectDotted'
  import MidContent from "./components/Items&Doctor/MainContent";
  import SwitchButton from "./components/ReserveForm/SwitchButton";
  
  import FooterContent from "./components/Footer/FooterContent";
  // import {  } from "./assets/fonts/fonts/";
export default {
  components:{
    Menu,InfoContent,FormContent,RectDotted,MidContent,SwitchButton,FooterContent
  }
};
</script>
<style>

#app {
  position: relative;
  /* font-family: "Avenir", Helvetica, Arial, sans-serif; */
  /* -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale; */
  text-align: center;
  color: #2c3e50;
}
#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
@font-face {
  font-family:IRANSansWeb ;
  src: url('./assets/fonts/fonts/IRANSansWeb(FaNum).woff');
}
@font-face {
  font-family:IRANSansWeb_Bold ;
  src: url('./assets/fonts/fonts/IRANSansWeb(FaNum)_Bold.woff');
}
@font-face {
  font-family:IRANSansWeb_Light ;
  src: url('./assets/fonts/fonts/IRANSansWeb(FaNum)_Light.woff');
}
#app{
  
  font-family:IRANSansWeb,IRANSansWeb_Bold ,IRANSansWeb_Light "Times New Roman", Times, serif !important;
}
.form-li-blue-border{
     border:1.5px solid #caeaf5;
     border-radius: 5px
}
.c{
 color:#176881
}
.cbb{
color:#4494ad
}
.bg-bl-blue{
  background: #4494ad
}
.clb{
  color:#49bcc5
}
.bg-li-blue{
  background: #caeaf5
}
.top-shape{
    background-image: linear-gradient(#dbeff6, #fff, #dbeff6);
  width:100%;
  height:20rem;
  position: absolute;
  /* transform: scale(1.5);
  border-right: 5px;
  border-bottom: 5px; */
      border-bottom-right-radius: 88% !important;
    border-bottom-left-radius: 88% !important;
    z-index: -1
}
</style>
