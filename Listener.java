/*******************************   Exportacion de datos desde Carriots

Campos: at, data.Temp
Consulta: device:Pt100_arduino@pquintan.pquintan 
Ordenación:
Formato: csv

***********************************/




The data stream will contain the following information:
{
  "tag":12345
}

Entity type: device
Event: Event Data Received
id: defaultaDevice@ExampleUser

If expression:
context.data.tag==12345

Then expression:
import com.carriots.sdk.utils.Email;
import com.carriots.sdk.utils.BasicHttp;

// Send an email to support@carriots.com
def email = new Email ();
today = new Date();

email.to="<your email>";
email.subject="RFID reader";
email.message="RFID reader. Card read: "+context.data.tag;
email.message="Context Data: "+context.data +" Date-time:"+today;
email.send();

import com.carriots.sdk.utils.Sms;
def sms = new Sms ();
sms.to="YOUR PHONE NUMBER HERE";
sms.message="Alarm ON";
sms.send();

// Open the door
def basicHttp = new BasicHttp();
basicHttp.url ="http://control.entrance:9090/openDoor?token=123456789";
basicHttp.verb ="GET";
basicHttp.send();

Else expression:
def basicHttp = new BasicHttp();
basicHttp.url ="http://control.entrance:9090/openDoor?token=123456789";
basicHttp.verb ="GET";
basicHttp.send();

import com.carriots.sdk.utils.Sms;
def sms = new Sms ();
sms.to="YOUR PHONE NUMBER HERE";
sms.message="Alarm OFF";
sms.send();



Name Ondata-SMS_email
Event Data Received
Entity: Pt100_arduino@pquintan.pquintan (Device)
Id. Developer: Pt100_arduino@pquintan.pquintan
If expression:
true

Then expression:


import com.carriots.sdk.utils.Email;
def email = new Email ();
today = new Date();
email.to="ariel@greenbeats.com"; //"pablo.quintanav@gmail.com
email.subject="Alerta de Temperatura en cámara de Frío GreenBeats";
//email.message="La Temperatura r. Card read: "+context.data.Temp"+ context.data +" Date-time:"+today;
email.message="La Temperatura en la cámara de frío a supereado el umbral definido";
email.send();


import com.carriots.sdk.utils.Sms;
def sms = new Sms ();
sms.to="0056995938588"; //"0056991624655";
sms.message="Alarma  Temperatura cámara de frío GreenBeats";
sms.send();


// Para producir un retraso en el envio de SMS, ya que solo se permite 1 cada minuto y un máximo de 5 SMS al día 
// pero para carriots enviar un SMS a varios numeros a la vez, cuenta como un solo SMS
import java.util.concurrent.TimeUnit;
w="33";
TimeUnit.SECONDS.sleep(30); // sleep 30 sec
TimeUnit.MINUTES.sleep(1); // sleep 1 minuto
w;


/// Operacion con fecha permitida en Carriots
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.text.SimpleDateFormat;
 
Instant t1 = Instant.now();
long hours = -3; // adaptando a la time Zone Chile GMT -4
Instant t2 = t1.plus(hours, ChronoUnit.HOURS);
//f=String.format("now %s and later %s", t1, t2);
SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



Date d =  Date.from(t2);
salida= s.format(d);
salida;
//////


/**************** Oficial Code Listener EMAIl ALERT *************/
import com.carriots.sdk.utils.Email;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import com.carriots.sdk.utils.BasicHttp;
import com.carriots.sdk.Device;


x = context.data.Temp;
Instant t1 = Instant.now();
long hours = -3; // adaptando a la time Zone Chile GMT -4 pero con cambio de hora -3
Instant t2 = t1.plus(hours, ChronoUnit.HOURS);
//f=String.format("now %s and later %s", t1, t2);
SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss");
Date d =  Date.from(t2);
salida= s.format(d);
float level = 7.3;

String [] emails = [ "marcia.olea@greenbeats.com ", // Marcia Olea > marcia.olea@greenbeats.com > +56963085501
					 "milton.carreno@greenbeats.com",//Milton Carreño > milton.carreno@greenbeats.com > +56951042469
					"ariel@greenbeats.com", //Ariel Negrete > ariel@greenbeats.com > +56995938588
					"pablo.quintanav@gmail.com",
					 "pquintan@induccioningenieria.cl"
			];
if( Float.parseFloat(x) > level ) { // Si la Temp actual es mayor que el nivel de alarma
  //Float.parseFloat(x) 
   
	def basicHttp = new BasicHttp( );
	basicHttp.url ="https://api.carriots.com/streams/?sort=at&order=-1";  //ordenado por fecha  y en orden inverso
	def map = ["carriots.apikey":"ec1ca74e3b17d52e00b6f9e2ffee22c3d3a06778538a28e472f816dbcfc11fcf"];
	basicHttp.headers = map;
	//def value = context.data.value;
	basicHttp.payload='{"protocol": "v2", "device": "Pt100_arduino@pquintan.pquintan"}';
	basicHttp.verb ="GET";
	xx =basicHttp.send(); // se rescatan 1000 datos
    xx.length()
	
	
	zz0 = xx.substring(430 , 430 + 60);
	int pos0 = zz0.indexOf("Temp");
	pos0 = pos0 + 7;
	tt0 = zz0.substring(pos0,pos0+5).replaceAll("\"", "").replaceAll(",", "");
	lecturaAnterior0 = Float.parseFloat( tt0) // se quitan las comillas dobes y se pasa a float

	// zz1 = xx.substring( 430 +  280 ,  480 +  280  + 60);
	zz1 = xx.substring( 430 +  280 * 1  ,  430 +  280 * 1  + 60);
	int pos1 = zz1.indexOf("Temp");
	pos1 = pos1 + 7;
	tt1 = zz1.substring(pos1,pos1+5).replaceAll("\"", "").replaceAll(",", "");
	lecturaAnterior1 = Float.parseFloat( tt1) // se quitan las comillas dobes y se pasa a float

	zz2 = xx.substring(980 ,980+ 60);
	int pos2 = zz2.indexOf("Temp");
	pos2 = pos2 + 7;
	tt2 = zz2.substring(pos2,pos2+5).replaceAll("\"", "").replaceAll(",", "");
	lecturaAnterior2 = Float.parseFloat( tt2) // se quitan las comillas dobes y se pasa a float

	//lecturaAnterior0 + "---" + lecturaAnterior1  + "---" + lecturaAnterior2;
	
	if( lecturaAnterior0 > level && lecturaAnterior1 >level && lecturaAnterior2 < level ) 
	{
		def email = new Email ();
        email.to = "marcia.olea@greenbeats.com, milton.carreno@greenbeats.com, ariel@greenbeats.com, pquintan@induccioningenieria.cl, pablo.quintanav@gmail.com";
        email.subject = "Alerta Temperatura Alta en cámara de Frío GreenBeats: " + x +" C";
		email.message="A las " + salida + " la Temperatura en la cámara de frío fue de " + x +" C a supereado el umbral definido de "+ level + " C.  \n \n www.induccioningenieria.cl" ;
		email.send();
	}

}

	// si las dos antepenultimas mediciones superan el umbral pero la tercera antepenultima no la hace se envia mail
	
	
	//xx.substring(0,480);  // se filtra en el pen ultimo valor 
	

	//def streams = Stream.findBy(["device": "Pt100_arduino@pquintan.pquintan"]);
    // my_temperature = " - ";
	
	//xx.length();

/*
//for(int i=0; i < 4; i++) {   my_temperature = streams[i].data + my_temperature; }
	
	//JSONParser parser = new JSONParser();
	//JSONObject json = (JSONObject) parser.parse(xx);

	JSONObject obj =  new JSONObject(xx);
	JSONArray arr = obj.getJSONArray("result");

	for(int i=0; i< 4 ); i++)  //arr.length(
	{
     String d =  arr.getJSONObject(i).getString("data");
    }
	d;
	*/
	zz = xx.substring(430, 430 + 60);
	int pos = zz.indexOf("Temp");
	pos = pos + 7;
	tt = zz.substring(pos,pos+5).replaceAll("\"", "").replaceAll(",", "");
	lecturaAnterior = Float.parseFloat( tt) // se quitan las comillas dobes y se pasa a float

	if( lecturaAnterior < level) { 
      
	// si la lectura Anterior es mayor que el umral => que ya alerto en caso contrario se debe alertar !!!
		int largo = emails.length;
      
           
      
        def email = new Email ();
        	email.to = "marcia.olea@greenbeats.com, milton.carreno@greenbeats.com, ariel@greenbeats.com, pquintan@induccioningenieria.cl, pablo.quintanav@gmail.com";
        	email.subject = "Alerta Temperatura Alta en cámara de Frío GreenBeats: " + x +" C";
			email.message="A las " + salida + " la Temperatura en la cámara de frío fue de " + x +" C a supereado el umbral definido de "+ level + " C.  \n \n www.induccioningenieria.cl" ;
			email.send();
			
      
      
	}
    
}
/*********** END SEND EMAIl ALERT ***********************************/

/**************** Oficial Code Listener SMS & EMAIl ALARM *****************/
import com.carriots.sdk.utils.Sms;
import com.carriots.sdk.utils.Email;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import com.carriots.sdk.utils.BasicHttp;

x = context.data.Temp;
Instant t1 = Instant.now();
long hours = -3; // adaptando a la time Zone Chile GMT -4
Instant t2 = t1.plus(hours, ChronoUnit.HOURS);
//f=String.format("now %s and later %s", t1, t2);
SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss");
Date d =  Date.from(t2);
salida= s.format(d);
level = 8.3;

String [] emails = [ "ariel@greenbeats.com", // Ariel
					"pablo.quintanav@gmail.com"
			];
String [] celulares = ["0056995938588", // Ariel
			 "0056951042469", // Milton
			 "0056942156777" , // Carla
             "0056991624655" //PQV
			];


if( Float.parseFloat(x) > level ) { // Si la Temp actual es mayor que el nivel de alarma
  
	def basicHttp = new BasicHttp( );
	basicHttp.url ="https://api.carriots.com/streams/?sort=at&order=-1";  //ordenado por fecha  y en orden inverso
	def map = ["carriots.apikey":"ec1ca74e3b17d52e00b6f9e2ffee22c3d3a06778538a28e472f816dbcfc11fcf"];
	basicHttp.headers = map;
	//def value = context.data.value;
	basicHttp.payload='{"protocol": "v2", "device": "Pt100_arduino@pquintan.pquintan"}';
	basicHttp.verb ="GET";
	xx =basicHttp.send(); // se rescatan 1000 datos
    //xx.length()
	//xx.substring(0,480);  // se filtra en el pen ultimo valor 
	
	zz0 = xx.substring(430 , 430 + 60);
	int pos0 = zz0.indexOf("Temp");
	pos0 = pos0 + 7;
	tt0 = zz0.substring(pos0,pos0+5).replaceAll("\"", "").replaceAll(",", "");
	lecturaAnterior0 = Float.parseFloat( tt0) // se quitan las comillas dobes y se pasa a float

	// zz1 = xx.substring( 430 +  280 ,  480 +  280  + 60);
	zz1 = xx.substring( 430 +  280 * 1  ,  430 +  280 * 1  + 60);
	int pos1 = zz1.indexOf("Temp");
	pos1 = pos1 + 7;
	tt1 = zz1.substring(pos1,pos1+5).replaceAll("\"", "").replaceAll(",", "");
	lecturaAnterior1 = Float.parseFloat( tt1) // se quitan las comillas dobes y se pasa a float

	zz2 = xx.substring(980 ,980+ 60);
	int pos2 = zz2.indexOf("Temp");
	pos2 = pos2 + 7;
	tt2 = zz2.substring(pos2,pos2+5).replaceAll("\"", "").replaceAll(",", "");
	lecturaAnterior2 = Float.parseFloat( tt2) // se quitan las comillas dobes y se pasa a float

	//lecturaAnterior0 + "---" + lecturaAnterior1  + "---" + lecturaAnterior2;
	
	if( lecturaAnterior0 > level && lecturaAnterior1 >level && lecturaAnterior2 < level ) {
		/*
	zz = xx.substring(430, 430 + 60);
	int pos = zz.indexOf("Temp");
	pos = pos + 7;
	tt = zz.substring(pos,pos+5).replaceAll("\"", "").replaceAll(",", "");
	lecturaAnterior = Float.parseFloat( tt); // se quitan las comillas dobes y se pasa a float

  
	if( lecturaAnterior < level) { 
	*/
	// si la lectura Anterior es mayor que el umral => que ya alerto en caso contrario se debe alertar !!!
		//if( emails.length  > 0.1 ) level
		
     def email = new Email ();
        	email.to = "marcia.olea@greenbeats.com, milton.carreno@greenbeats.com, ariel@greenbeats.com, pquintan@induccioningenieria.cl, pablo.quintanav@gmail.com";
        	email.subject = "ALARMA Temperatura ANORMAL en cámara de Frío GreenBeats: " + x +" C";
			email.message="A las " + salida + " la Temperatura en la cámara de frío fue de " + x +" C a supereado el umbral definido de "+ level + " C.  \n \n www.induccioningenieria.cl" ;
			email.send();
				 
     
			def sms = new Sms ();
			sms.to = "0056963085501, 0056951042469, 0056995938588, 0056991624655"; // Marcia, Milton, Ariel , PQV
			sms.message="A las " + salida + "ALARMA Temperatura ANORMAL en cámara de Frío GreenBeats: "+ x +" C";
			sms.send();
			//TimeUnit.SECONDS.sleep(61); // sleep 1 min 1sec
	}
    
}



/*********** END SMS & EMAIl ALARM *************************************************/

Have you tried with the phone number in international format?
       "00-56-991-624-655"
sms.to="00-34-678-XXX-XXX"; 
00 -> International prefix
34 -> Country code (34 is Spain)
678XXXXXX -> your phone number.
//sms.to="0034123456789";  
You can try it from the debug terminal ( Debug Menu - Console) so you don't have to fire the listener.


https://api.carriots.com/runner/email_temp@pquintan.pquintan/run

// Query para modificar la data
import com.carriots.sdk.utils.BasicHttp;
def basicHttp = new BasicHttp( );
basicHttp.url ="https://api.carriots.com/streams/?sort=at&order=-1";  //ordenado por fecha  y en orden inverso
def map = ["carriots.apikey":"ec1ca74e3b17d52e00b6f9e2ffee22c3d3a06778538a28e472f816dbcfc11fcf"];
basicHttp.headers = map;
def value = context.data.value;
basicHttp.payload='{"protocol": "v2", "device": "defaultDevice@exampleuser.exampleuser", "at": "now", "data": {"value" :"' +value+  '"}}';
basicHttp.verb ="POST";
basicHttp.send()
//

import com.carriots.sdk.utils.BasicHttp;
def basicHttp = new BasicHttp( );
basicHttp.url ="https://api.carriots.com/streams/";  
def map = ["carriots.apikey":"ec1ca74e3b17d52e00b6f9e2ffee22c3d3a06778538a28e472f816dbcfc11fcf"];
basicHttp.headers = map;
//def value = context.data.value;
basicHttp.payload='{"protocol": "v2", "device": "Pt100_arduino@pquintan.pquintan"}';
basicHttp.verb ="GET";
x = basicHttp.send();
x.substring(2,60);

                 'total_documents":25933,"result":[{"_id":"5aeb5d2fbd2a42930'
Details: array ( 'total_documents' => 25927, 'result' => array ( 0 => array ( '_id' => '5aeb5d2fbd2a42930b8b456c', 
'protocol' => 'v2', 'device' => 'Pt100_arduino@pquintan.pquintan', 'at' => 1525374255, 'data' => array ( 'Temp' => '11.30', ),
 '_t' => 'str', 'id_developer' => '1240a9bd47daa5fb341d3bea70b73cdd62ee10a34f9fa92ecaba59771ef8cb82@pquintan.pquintan', 
 'created_at' => 1525374255,
 
 
 //Last test
import com.carriots.sdk.utils.BasicHttp;
import groovy.json.JsonSlurper;

def json = new JsonSlurper();
def basicHttp = new BasicHttp();

basicHttp.url = "https://api.carriots.com/streams/"";
basicHttp.verb = "GET";
def content = ["Content-Type": "application/json", "Carriots.apiKey": "ec1ca74e3b17d52e00b6f9e2ffee22c3d3a06778538a28e472f816dbcfc11fcf"];
basicHttp.headers = content;
def response = json.parseText(basicHttp.send());

response["created_at"];

http://api.carriots.com/devices/Pt100_arduino@pquintan.pquintan/streams/?sort=at&order=-1

 
///  Test en debug 
import com.carriots.sdk.utils.BasicHttp;

def basicHttp = new BasicHttp( );
basicHttp.url ="https://api.carriots.com/streams/?sort=at&order=-1";  //ordenado por fecha  y en orden inverso
def map = ["carriots.apikey":"ec1ca74e3b17d52e00b6f9e2ffee22c3d3a06778538a28e472f816dbcfc11fcf"];
basicHttp.headers = map;
//def value = context.data.value;
basicHttp.payload='{"protocol": "v2", "device": "Pt100_arduino@pquintan.pquintan"}';
basicHttp.verb ="GET";
x =basicHttp.send(); // se rescatan 1000 datos
x.substring(0,480);  // se filtra en el pen ultimo valor 
f = Float.parseFloat( x.substring(446,452).replaceAll("\"", "") ) // se quitan las comillas dobes y se pasa a float
f + 5.01
// si el valor rescatdado es mayor que el umral => que ya alerto en caso contrario se debe alertar !!!

//x.substring(x.length() -180, x.length() )

// Eliminar comillas dobles de una cadena
theText.replaceAll("\"", "");

Message: OK 
Details: ',"data":{"Temp":"6.15"},"_t":"str","id_developer":"8fefb926c979c0e9f4adca7fb5e13e9a2707da00f13fa128b2d98f76189935ce@pquintan.pquintan",
"created_at":1525555260,"owner":"pquintan"}]}'


{"Temp":"21.73"}	 
{"Temp":"8.6"}


texto = 'la a es la vida,fdvf gggffv "Temp":"2.23", de la a" k ¿';
texto= texto.substring(8,50);
t = "Temp";  
pos = texto.indexOf(t);
pos = pos + 7;
tt= texto.substring(pos,pos+5).replaceAll("\"", "");
tt




//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++



aa='{"total_documents":69394,"result":[{"_id":"5bb79488bd2a42bdbb8b45ae","protocol":"v2","device":"Pt100_arduino@pquintan.pquintan","at":1538757768,"data":{"Temp":"5.24"},"_t":"str","id_developer":"f069304baf43c3cdd2a6230f249036a07f93b72e7041dadc0f0df5a6b29ed8cb@pquintan.pquintan","created_at":1538757768,"owner":"pquintan"},{"_id":"5bb793d3bd2a42d4b98b45b1","protocol":"v2","device":"Pt100_arduino@pquintan.pquintan","at":1538757587,"data":{"Temp":"4.70"},"_t":"str","id_developer":"0343f6742d7237646c6b3eec1811ba50399eed50ad9642f7674e11db73c7e952@pquintan.pquintan","created_at":1538757587,"owner":"pquintan"},{"_id":"5bb7931ebd2a42b1bc8b45a4","protocol":"v2","device":"Pt100_arduino@pquintan.pquintan","at":1538757406,"data":{"Temp":"4.55"},"_t":"str","id_developer":"e93d91f3d91ff6e8dc97466eecd847097b7a94bcaa591cd8edbd4a92739a3698@pquintan.pquintan","created_at":1538757406,"owner":"pquintan"},{"_id":"5bb79269bd2a42e5b98b45b8","protocol":"v2","device":"Pt100_arduino@pquintan.pquintan","at":1538757225,"data":{"Temp":"5.09"},"_t":"str","id_developer":"cf3ae3bf4974038937a16fab39528383cdd877d94614ed443f09ff798c17e2c4@pquintan.pquintan","created_at":1538757225,"owner":"pquintan"},{"_id":"5bb791b3b' 




