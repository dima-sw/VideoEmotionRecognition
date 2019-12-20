// please note, 
// that IE11 now returns undefined again for window.chrome
// and new Opera 30 outputs true for window.chrome
// but needs to check if window.opr is not undefined
// and new IE Edge outputs to true now for window.chrome
// and if not iOS Chrome check
// so use the below updated condition
var isChromium = window.chrome;
var winNav = window.navigator;
var vendorName = winNav.vendor;
var isOpera = typeof window.opr !== "undefined";
var isIEedge = winNav.userAgent.indexOf("Edge") > -1;
var isIOSChrome = winNav.userAgent.match("CriOS");

if (isIOSChrome) {
   // is Google Chrome on IOS
   console.log('is Google Chrome IOS');
   alert('is Google Chrome IOS');
} else if(
   isChromium !== null &&
   typeof isChromium !== "undefined" &&
   vendorName === "Google Inc." &&
   isOpera === false &&
   isIEedge === false
) {
   // is Google Chrome
   console.log('is Google Chrome');
   //alert('is Google Chrome');
} else { 
   // not Google Chrome 
   console.log('not Google Chrome');
   
   alert("Ehi, this isn't Google Chrome, try to download and use chrome for a better experience!!! :)"); 
}