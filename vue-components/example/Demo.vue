<template>
  <div class="opt-container">
    <div class="row">
      <input type="text" maxlength="1" v-model="d1" class="rounded"/>
      <input type="text" maxlength="1" v-model="d2" class="rounded"/>
      <input type="text" maxlength="1" v-model="d3" class="rounded"/>
      <input type="text" maxlength="1" v-model="d3" class="rounded"/>
      <input type="hidden" name="otpValue"/>
    </div>
    <div class="row">

    </div>
  </div>
</template>

<script>
  export default {
    name: 'OTP',
    props: {
      msg: String,
    },
    watch: {
      d1 (value) {
        this.d1 = value;
        this.checkOtpD(value)
      }
    },
    methods: {
      checkOtpD(value) {
        return false;
      }
    },
    data () {
      return {
        d1: '0',
        d2: '0',
        d3: '0',
        d4: '0'
      }
    },
    validations: {}
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  input[type=text] {
    width: 40px;
    height: 40px;
    margin: 0px 2px;
    text-align: center;
    line-height: 1.5em;
    font-size: 1rem;
    border: 1px solid #90979E;
  }

  .opt-container {
    direction: ltr !important;
  }
</style>
