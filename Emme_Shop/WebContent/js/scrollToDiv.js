
function scrollToDiv(id) {
  $('html,body').animate({
    scrollTop: $('#'+id).offset().top
  },'slow');
  document.getElementById('id').scrollIntoView();
}
function scrollToDivForAll(id) {
    document.getElementById('id').scrollIntoView();
  }