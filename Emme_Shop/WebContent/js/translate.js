function googleTranslateElementInit() {
    new google.translate.TranslateElement({
          pageLanguage: 'it',
          autoDisplay: false,
          includedLanguages: 'it,fr,en,ja,ko,in,vi,ru,th,zh-CN,zh-TW',
          layout: google.translate.TranslateElement.FloatPosition.TOP_RIGHT,
          gaTrack: true, gaId: 'UA-xxxxxx-x'
    }, 'google_translate_element');

function changeGoogleStyles() {
        if($('.goog-te-menu-frame').contents().find('.goog-te-menu2').length) {
            $('.goog-te-menu-frame').contents().find('.goog-te-menu2').css({
                'max-width':'100%',
                'overflow-x':'auto',
                'box-sizing':'border-box',
                'height':'auto',
                'border':'0',
                'width': '180px'
            }); 
            $('.goog-te-menu-frame').contents().find('.goog-te-menu2 table').css({
                
                'width': '180px'
            });
        } else {
            setTimeout(changeGoogleStyles, 50);
        }
    }
    changeGoogleStyles();
}