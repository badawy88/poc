<template>
  <div id="app">
    <OTP v-bind:digits="6" :use-separator="true" :separator="'-'" id="otp"/>
  </div>
</template>

<script>
import OTP from './components/OTP.vue'

export default {
  components: {
    OTP
  }
}
</script>
