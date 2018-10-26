

	 
	
if(sessionStorage.myValuex !== "valuex") Salir();
var f = "dsf dsfdsds";
var miBlob = new Blob([f], {type: 'text/plain'});
window.open(URL.createObjectURL(miBlob));



/*
$(document).ready(function(){
    var ua = navigator.userAgent;

    if(/Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini|Mobile|mobile|CriOS/i.test(ua))
       $('a.mobile-other').show();

    else if(/Chrome/i.test(ua))
       $('a.chrome').show();

    else
       $('a.desktop-other').show();
});
*/
var mob = false;

function mobileAndTabletmob() {  
  (function(a){  
	if(/(android|bb\d+|meego).+mobile|avantgo|bada\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|iris|kindle|lge |maemo|midp|mmp|mobile.+firefox|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\.(browser|link)|vodafone|wap|windows ce|xda|xiino|android|ipad|playbook|silk/i.test(a)||/1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\-(n|u)|c55\/|capi|ccwa|cdm\-|cell|chtm|cldc|cmd\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\-s|devi|dica|dmob|do(c|p)o|ds(12|\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\-|_)|g1 u|g560|gene|gf\-5|g\-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd\-(m|p|t)|hei\-|hi(pt|ta)|hp( i|ip)|hs\-c|ht(c(\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\-(20|go|ma)|i230|iac( |\-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\/)|klon|kpt |kwc\-|kyo(c|k)|le(no|xi)|lg( g|\/(k|l|u)|50|54|\-[a-w])|libw|lynx|m1\-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m\-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\-2|po(ck|rt|se)|prox|psio|pt\-g|qa\-a|qc(07|12|21|32|60|\-[2-7]|i\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\-|oo|p\-)|sdk\/|se(c(\-|0|1)|47|mc|nd|ri)|sgh\-|shar|sie(\-|m)|sk\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\-|v\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\-|tdg\-|tel(i|m)|tim\-|t\-mo|to(pl|sh)|ts(70|m\-|m3|m5)|tx\-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|yas\-|your|zeto|zte\-/i.test(a.substr(0,4))) 
		mob = true; } ) (navigator.userAgent||navigator.vendor||window.opera);
	if(mob) document.getElementById("mobil").innerHTML = "mobil";
	//return mob;
};

	
// Opera 8.0+
var isOpera = (!!window.opr && !!opr.addons) || !!window.opera || navigator.userAgent.indexOf(' OPR/') >= 0;
if(isOpera) {console.log("Opera");document.getElementById("browser").innerHTML = "Opera"; }
// Firefox 1.0+
var isFirefox = typeof InstallTrigger !== 'undefined';
if(isFirefox) {console.log("Firefox");document.getElementById("browser").innerHTML = "Firefox"; }
// Safari 3.0+ "[object HTMLElementConstructor]" 
var isSafari = /constructor/i.test(window.HTMLElement) || (function (p) { return p.toString() === "[object SafariRemoteNotification]"; })(!window['safari'] || (typeof safari !== 'undefined' && safari.pushNotification));
if(isSafari) {console.log("Safari");document.getElementById("browser").innerHTML = "Safari"; }
// Internet Explorer 6-11
var isIE = /*@cc_on!@*/false || !!document.documentMode;
if(isIE) {console.log("IE");document.getElementById("browser").innerHTML = "IE"; }
// Edge 20+
var isEdge = !isIE && !!window.StyleMedia;
if(isEdge) {console.log("Edge");document.getElementById("browser").innerHTML = "Edge"; }
// Chrome 1+
var isChrome = !!window.chrome && !!window.chrome.webstore;
if(isChrome) { 
	console.log("Chrome"); 
	// document.getElementById("browser").innerHTML = "Chrome"; 
}
// Blink engine detection
//var isBlink = (isChrome || isOpera) && !!window.CSS;
// if(isBlink) {console.log("Blink");document.getElementById("browser").innerHTML = "Blink"; }

	
	
	   calculateRequests();
	   var myVar = setInterval(calculateRequests, 180000);
	// Device ID developer: Pt100_arduino@pquintan.pquintan
	
	//var apikey = 'ec1ca74e3b17d52e00b6f9e2ffee22c3d3a06778538a28e472f816dbcfc11fcf'; //pqv key
 // device = 'Pt100_arduino@pquintan.pquintan';
 var mob = false;
 
function calculateRequests(){

  var currentDate= new Date;
  // Save the current time in the now variable.
  var now= parseInt(currentDate.getTime()/1000);
  // Instantiate the variable limit and set its value to one day before the now variable.
  var limit=currentDate.setDate(currentDate.getDate() - 1);
      limit2=parseInt(currentDate.getTime()/1000);
	   makeCorsRequest("GET", "http://api.carriots.com/devices/Pt100_arduino@pquintan.pquintan/streams/?sort=at&order=-1");
  // Make the CORS request to Carriots to get all the streams between now and the limit (one natural day before).
 // makeCorsRequest('GET', "http://api.carriots.com/devices/madrid@carriotsMeteo.carriotsMeteo/streams/?at_to="+now+"&at_from="+limit, "day");
  // Set the limit variable to 6 days before its current value (7 days total before the now variable).
 // limit=currentDate.setDate(currentDate.getDate() - 6);
 // limit2=parseInt(currentDate.getTime()/1000);
  // Make the CORS request to Carriots to get all the streams between now and the limit (7 natural day before).
 // makeCorsRequest('GET', "http://api.carriots.com/devices/madrid@carriotsMeteo.carriotsMeteo/streams/?at_to="+now+"&at_from="+limit, "week");
  // Set the limit variable to 23 days before its current value (30 days total before the now variable).
  //limit=currentDate.setDate(currentDate.getDate() - 23);
  //limit2=parseInt(currentDate.getTime()/1000);
  // Make the CORS request to Carriots to get all the streams between now and the limit (30 natural day before).
 // makeCorsRequest("GET", "http://api.carriots.com/devices/madrid@carriotsMeteo.carriotsMeteo/streams/?at_to="+now+"&at_from="+limit, "month");
  
}

// Create the XHR object.
function createCORSRequest(method, url) {

  var xhr = new XMLHttpRequest();
  if ("withCredentials" in xhr) {
    // XHR for Chrome/Firefox/Opera/Safari.
    xhr.open(method, url, true);
  } else if (typeof XDomainRequest != "undefined") {
    // XDomainRequest for IE.
    xhr = new XDomainRequest();
    xhr.open(method, url);
  } else {
    // CORS not supported.
    xhr = null;
  }
  return xhr;
}

// Make the actual CORS request.
function makeCorsRequest(meth, url, timePeriod) {
  var jsonData = null;
  var xhr = createCORSRequest(meth, url);
  //var apikey= 'a3dd2a33c514de9ed0ad1e8e751a82a8c699916858b1ad0a6e2425d71cce48ea';
  //var device = 'madrid@carriotsMeteo.carriotsMeteo';
  var apikey = 'ec1ca74e3b17d52e00b6f9e2ffee22c3d3a06778538a28e472f816dbcfc11fcf'; //pqv key
  //device = 'Pt100_arduino@pquintan.pquintan';
  //device = "Pt100_arduino"; //device:Pt100_arduino@pquintan.pquintan

  if (xhr) {
    alert('CORS not supported');
    return;
  }
  
  // Add the needed headers to make the CORS request to Carriots.
 // xhr.setRequestHeader('Host', 'api.carriots.com');
  xhr.setRequestHeader('carriots.apiKey', apikey);
  xhr.setRequestHeader('Accept', 'application/json');
  // xhr.setRequestHeader('User-Agent', 'Carriots-client');
  xhr.setRequestHeader('Content-Type', 'application/json');

  // Response handlers.
  xhr.onload = function() {
    var text = xhr.responseText;
    if(meth!='POST'){ 
      // Print the value returned by decode function in each input box.
	  decode(text);
      /*switch(timePeriod){
        case 'day': document.getElementById('day').value=decode(text); break;
        case 'week': document.getElementById('week').value=decode(text); break;
        case 'month': document.getElementById('month').value=decode(text); break;
		default : decode(text);
      }*/
    }
    
  };

  xhr.onerror = function() {
    //alert('There was an error making the request.');
	 window.location.reload();
  };

  xhr.send(jsonData);
}

 
function decode(text){
  // Parse the text returned from the request into a JSON object.
  obj = JSON.parse(text);
  var temp=0;
  var avg=0;
  var tiempo = []; 
  var valor = [];
  var tiempo3 = []; 
  var valor3 = [];
  var promedio = 0;
 // console.log("obj" ,obj); 
  // console.log("at" ,obj.result[0]["at"]);
  // console.log("temp",obj.result[0]["data"]["Temp"]);
  // console.log("total", obj.total_documents);
  // Get the temperature for each data set returned in the request (one for every hour).
  for(var i=0; i<obj.result.length; i++){
    temp=obj.result[i].data.temp;
    // Add the temperature to the sum of temperatures.
    avg+=parseFloat(temp);
  }
  avg=(parseFloat(avg)/largo).toFixed(2);
  
  //************************************ Grafico **************+++
	var largo = obj.result.length;
	largo = 480;
	console.log("entrando");
	for(var i=0; i<largo; i++){
		tiempo[i] = timeConverter( obj.result[largo -i]["at"] ); // Fecha de la toma de Tempertura  UNIX_timestamp 
		valor[i] =  (    obj.result[largo -i]["data"]["Temp"] ); // Valor de la Tempertura  
		console.log(" en  i:",i,"valor[i]:", valor[i] )
		//++++++++++++++
		/*
		console.log("tipo: ", typeof( parseFloat(valor[i]) ), "  i:",i)
		if( typeof( parseFloat(valor[i]) )  == "number" )  valor[i] =  parseFloat(valor[i]) - 5; 
		else  valor[i] = parseFloat(valor[i-1]) ;  // ajuste del valor real son aprox 4°C menos
		if (valor[i] < 0)   valor[i] = ( valor[i-1] + valor[i+1] ) / 2; // ajuste si el valor es negativo
		*/
		
		//***************
		promedio = parseFloat(promedio) + parseFloat( valor[i] );
		console.log("i:",i,"valor[i]:", valor[i], "++++++++++++promedio",promedio )
	}
	console.log("+++++++++++++++++++++promedio",promedio )
	promedio = promedio / largo;
	console.log("+++++++++++++++++++++promedio",promedio )
	promedio = promedio.toFixed(2);
	console.log("+++++++++++++++++++++promedio",promedio )
	console.log("valor[74]:", valor[74], valor[75],valor[76], valor[77],valor[78], valor[79] )	
  p = promedio.toString();
  document.getElementById("bb").innerHTML = obj.result[0]["data"]["Temp"] +"°C   /" +  timeConverter( obj.result[0]["at"]);
  document.getElementById("aa").innerHTML = p +"°C";
  
  
  //console.log("p:",p);
	var data2 = {
	  labels: tiempo, //["0s", "10s", "20s", "30s", "40s", "50s", "60s"], //at
	  datasets: [{
		label: "Tempertura °C",
		data: valor, // [0, 59, 75, 20, 20, 55, 40], // Temp
		borderColor: 'orange',
		backgroundColor: "#FFFF00"
			}]
	};
 
	var options2 = {
					  legend: {
								display: true,
								position: 'top',
								labels: {
								  boxWidth: 80,
								  fontColor: 'black'}
								}
	  };	
	var ctx2 = document.getElementById("myChart2").getContext('2d');
	var myLineChart = new Chart(ctx2, {
		type: 'line',
		data: data2,
		options: options2
	});
  
  // Fin grafico ************
  
  
  /*
  // grafico3 ************
  	var largo3 = obj.result.length;
	//largo = 480;
	for(var i=0; i<largo3; i++){
		tiempo3[i] = timeConverter( obj.result[largo3 -1 -i]["at"] ); // Fecha de la toma de Tempertura  UNIX_timestamp 
		valor3[i] =  obj.result[largo3 -1 -i]["data"]["Temp"] ; // Valor de la Tempertura  
		//promedio = promedio + parseInt( valor[i] );
	}
	
	console.log("*********************");
	console.log("obj:", obj.result[0]["at"]);
	//console.log("t:", t( obj.result[0]["at"]));
	
	
	
	var data3 = {
	labels: tiempo3, //["0s", "10s", "20s", "30s", "40s", "50s", "60s"], //at
	datasets: [{
		label: "Tempertura °C",
		data: valor3, // [0, 59, 75, 20, 20, 55, 40], // Temp
		borderColor: 'orange',
		backgroundColor: "#FFFF00"
		}]
	};
  
	var ctx3 = document.getElementById("myChart3").getContext('2d');
	var myLineChart3 = new Chart(ctx3, {
    type: 'line',
    data: data3,
    options: options2
	});
	//Fin grafico3 ************
	*/
	
   
  
  // Return the average temperature for the amount of hours (which will be the value of i when it leaves the for loop).
}

function Salir(){window.location.href='index.html'}


//console.log("Tested Sinac");

function timeConverter(UNIX_timestamp){
		mobileAndTabletmob();
		
		var           a = new Date( (UNIX_timestamp - 0 * 3600 )* 1000);
		if(isFirefox) a = new Date( (UNIX_timestamp + 1 * 3600 )* 1000);
		if(isChrome)  a = new Date( (UNIX_timestamp - 0 * 3600 )* 1000);
		if(mob)       a = new Date( (UNIX_timestamp - 5 * 3600 )* 1000);
		var months = ['Ene','Feb','Mar','Abr','May','Jun','Jul','Ago','Sep','Oct','Nov','Dic'];
		var year = a.getFullYear();  // Año AAAA
		var month = months[a.getMonth()]; //Mes MM
		var date = a.getDate(); // Dia DD
		var hour = a.getHours(); // Hora HH por cambio horario +1 ***************************************
	  
		
	  /*if(mob){	 hour = hour + 1;
				if(hour == 24) { hour = 0 ; }
	  }
	  
	  if(isChrome){	 hour = hour - 1;
				if(hour == 24) { hour = 0 ; }
	  }*/
	  
	  /*
	  if(mob){
		  if(hour == 0) hour = 4;
		  else { 	if(hour >19) { if(hour == 24) { hour = 0 ; date = date + 1; } else {hour = hour - 20;} }
					else { hour = hour + 4;} 
				} 
	  }
	  if(hour == 24) { hour = 0 ; date = date + 1; }
	  */
	  var min = a.getMinutes(); // Min  MM
	  if(min < 10) min = "0" + min;
	  
	  var sec = a.getSeconds(); // Segundos SS
	  var time = date + '-' + month + '-' + year + ' ' + hour + ':' + min ; //+ ':' + sec ;
	  return time;
}
	  // console.log("o.q",o.q);
	   


function t(date){
    var newDate = new Date(date.getTime()+date.getTimezoneOffset()*60*1000);
    var offset = date.getTimezoneOffset() / 60;
    var hours = date.getHours();

    newDate.setHours(hours - offset);
    return newDate;
}
	   
	   
function Descargar() {
	console.log("descargar");
	
}
