<template>
  <div class="container opt-container">
    <div class="row">
      <span v-bind:key="index" v-for="index in digits">
      <input type="text" maxlength="1"
             :id="id + '_' + element_name + '' + index"
             v-on:change="handleChange"
             v-on:keypress="handleKeypress"
             class="form-control rounded"
             v-on:keyup="keyup"
             autocomplete="off"
             :name="name == null ? id : name"
             required>
        <span v-if="useSeparator && digits>1 && index == digits/2" class="separator" v-text="separator"></span>
      </span>
      <input type="hidden" :name="id + '_otpValue'" :id="id + '_otpValue'"/>
    </div>
  </div>
</template>

<script>
export default {
  name: 'OTP',
  props: {
    id: String,
    name: String,
    digits: {
      type: Number,
      default: 4
    },
    useSeparator: {
      type: Boolean,
      default: false
    },
    separator: {
      type: String,
      default: '-'
    },
    element_name: {
      type: String,
      default: 'd'
    }
  },
  methods: {
    handleChange (elem, oldVal) {
      const value = elem.target.value
      if (value === '' || isNaN(value)) {
        elem.target.classList.add('is-invalid')
        elem.target.classList.remove('is-valid')
      } else {
        elem.target.classList.remove('is-invalid')
        elem.target.classList.add('is-valid')
      }
      document.getElementById(`${this.id}_otpValue`).value = this.getOtp()
    },
    handleKeypress (elem) {
      const value = elem.key
      if (isNaN(value) || value === ' ') {
        elem.preventDefault()
      }
    },
    keyup (elem) {
      const keyCode = elem.keyCode
      if (keyCode === 37 || keyCode === 8) {
        this.goBack(elem)
      } else if (keyCode !== 9 && keyCode !== 16) {
        this.goNext(elem)
      }
      if (keyCode === 32 || keyCode === 46) {
        elem.target.value = ''
      }
    },
    goNext (elem) {
      const elemIndex = parseInt(elem.target.id.replace(this.id + '_' + this.element_name, ''))
      this.go(elemIndex + 1, elemIndex + 1 <= this.digits)
    },
    goBack (elem) {
      const elemIndex = parseInt(elem.target.id.replace(this.id + '_' + this.element_name, ''))
      this.go(elemIndex - 1, elemIndex - 1 > 0)
    },
    go (elemIndex, condition) {
      if (condition) {
        const newElem = this.getField(elemIndex)
        newElem.focus()
        newElem.select()
      }
    },
    getOtp () {
      let value = ''
      for (let i = 1; i <= this.digits; i++) {
        const val = this.getField(i).value
        if (val === '') {
          value = ''
          break
        }
        value += val
      }
      return value
    },
    getField (index) {
      return document.getElementById(`${this.id}_${this.element_name}${index}`)
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  input[type=text] {
    width: 40px;
    height: 40px;
    margin: 2px 2px;
    text-align: center;
    line-height: 1.5em;
    font-size: 1.2rem;
  }
  .separator {
    margin: 0px 10px;
  }

  .opt-container * {
    direction: ltr !important;
  }
</style>
