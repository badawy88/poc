let language
/**
 * Check the language settings,
 * set language to default.
 */
let checkLanguage = function () {
  const queryString = window.location.search
  if (queryString !== null && queryString !== '') {
    const urlParams = new URLSearchParams(queryString)
    language = urlParams.get('lang')
    //window.location.assign( window.location.href.replace(queryString, ''))
  } else if (localStorage.getItem('lang') !== null) {
    language = localStorage.getItem('lang')
  } else {
    language = 'ar'
  }
  localStorage.setItem('lang', language)
  $('html').attr('lang', language)
}

function checkOtp () {
  const otp = $('.otp')
  if (otp.length > 0) {
    otp.attr('style', 'width:23% !important; height: 40px;text-align:center;border:1px solid #90979E;')
    otp.attr('maxlength', '1')
    otp.parent().attr("style" , "direction:ltr");
    otp.addClass("rounded")
    if (language === 'ar') {
      otp.parent().addClass("flex-column-reverse");
    } else {
      otp.parent().removeClass("flex-column-reverse");
    }
  }
}


(function() {
  'use strict';
  window.addEventListener('load', function() {
// Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
// Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();

$(document).ready(function () {
  checkLanguage()
  checkOtp()
})