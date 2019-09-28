<template>
  <button type="button" @click="setTiming" :class="isActiv">{{time|convertEnToFaDig}} {{tTime}}</button>
</template>

<script>
export default {
  props: {
    isActive: {
      type: Boolean,
      default: false
    },
    time: {
      type: String,
      default: "19:00"
    },
    tTime: {
      type: String,
      default: "بعد از ضهر"
    },
    index: {
      type: Number,
      default: false
    },
    isMorning: {
      type: Boolean,
      default: false
    }
  },
  methods: {
    setTiming() {
      store.dispatch("setTimming", {
        isMorning: this.isMorning,
        chooseIndex: this.index
      });
    }
  },
  computed: {
    butClass() {
      return this.isActiv
        ? "mr-1 mb-1 btn btn-info btn-sm"
        : "mr-1 mb-1 btn btn-light btn-sm";
    },
    isActiv() {
      let val = this.$store.state.chooseValue;
      console.log(val);
      if (val.isMorning == this.isMorning && this.index == val.chooseIndex) {
        return "mr-1 mb-1 btn btn-info btn-sm";
      } else {
        return "mr-1 mb-1 btn btn-light btn-sm";
      }
    }
  }
};
</script>

<style scoped>
button {
  max-height: 1.5rem;
  min-width: 3rem;
  font-family: IRANSansWeb_bold !important;
  font-size: 0.6rem;
}
</style>