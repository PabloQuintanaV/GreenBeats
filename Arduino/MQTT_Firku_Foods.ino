#include <SPI.h>
#include <Ethernet.h>
#include <PubSubClient.h> // You must include the library here in order to use it in the sketch
#include <Average.h>

// Enter a MAC address for your controller below.
// Newer Ethernet shields have a MAC address printed on a sticker on the shield.
// static byte mac[] = { 0xCA, 0xCA, 0xDE, 0xBA, 0xCA, 0xED };
static byte mac[] = { 0x74,0x69,0x69,0x2D,0x30,0x31 };
//static byte mymac[] = {0xDD,0xDD,0xDD,0x00,0x01,0x05};
// Set the static IP address to use if the DHCP fails to assign.
IPAddress ip(192,168,1,12); // Your IP Address

// 
////////////////////////////////////////
// CARRIOTS Connectivity definitions. //
////////////////////////////////////////
#define CARRIOTS_DEVICE      "Pt100_arduino"    // "YOUR DEVICE NAME HERE"
#define CARRIOTS_USERNAME    "pquintan"// "YOUR USER yNAME HERE"
#define CARRIOTS_APIKEY       "ec1ca74e3b17d52e00b6f9e2ffee22c3d3a06778538a28e472f816dbcfc11fcf"   // "YOUR APIKEY HERE"

#define CARRIOTS_MQTT_PORT    1883
#define CARRIOTS_MQTT_HOST    "mqtt.carriots.com" //or "mqttbroker.carriots.com"
#define CARRIOTS_MQTT_TOPPIC  "/streams" // Or "/status"

const String DEVICE_ID = CARRIOTS_DEVICE "@" CARRIOTS_USERNAME "." CARRIOTS_USERNAME;
////////////////////////////////////////
#define TEMP_SENSOR 1 // sensor entrada analogo 0
int sensorValor = 0;
float f1 = 0;
float t1 = 0;
// Initialize the Ethernet client.
 Average <float> ave(10); // 10 datos float
 
EthernetClient eth_client;

// Instantiate an instance of the MQTT client.
PubSubClient mqtt_client(CARRIOTS_MQTT_HOST, CARRIOTS_MQTT_PORT, eth_client);

void mqtt_connect() {
  // Loop until we're connected to MQTT.
  while (!mqtt_client.connected()) {
    Serial.print("Attempting MQTT connection to... ");
    Serial.println(CARRIOTS_MQTT_HOST);
    // Attempt to connect.
    if (mqtt_client.connect(CARRIOTS_USERNAME, CARRIOTS_APIKEY, NULL)) {
      Serial.println("Success conected to Carriots Server");
    // Failed connection.
    } else {
      Serial.print("Failed connection: rc=");
      Serial.print(mqtt_client.state());      
      Serial.println(". Retry on 1 second.");
      // Wait 1 second before retrying
      delay(1000);
    }
  }
  Serial.println("Success coonected to Carriots"); //deberia indicar conetado a Carrots
}

void mqtt_publish(char* frame) {
  // Note - the default maximum packet size is 128 bytes.
  // You may need to increase the value of MQTT_MAX_PACKET_SIZE in
  //   Arduino/libraries/pubsubclient/src/PubSubClient.h
  //   (Increased to 256 on this example)
  Serial.print("Publishing at "CARRIOTS_MQTT_TOPPIC ": ");
  Serial.println(frame);
  // Publish data frame. 
  if (mqtt_client.publish(CARRIOTS_APIKEY CARRIOTS_MQTT_TOPPIC, frame)) { // No comma between APIKEY and TOPPIC.
    Serial.println("Published.");
  } else {
    Serial.println("Failed publishing.");
  }
  Serial.println();
}

char* get_frame() {
  // Build Data JSON.
  //String data_json  = "{\"Sample_Value_1\":10,\"Sample_Value_2\":\"Sample 2\"}";
  //String data_json    = "{\"Temp\":\""+String(t1)+"\"}";
  // Build Frame JSON.
  // String frame_json = "{\"protocol\":\"v2\",\"device\":\""+DEVICE_ID+"\",\"at\":\"now\",\"data\":"+data_json+"}";
// old String frame_json = "{\"protocol\":\"v2\",\"device\":\""+DEVICE_ID+"\",\"data\":"+data_json+"}";
String frame_json = "{\"protocol\":\"v2\",\"device\":\""+DEVICE_ID+"\",\"at\":\"now\",\"data\":{\"Temp\":\""+String(t1)+"\"}}";
 // String frame_json = "{\"protocol\":\"v2\",\"device\":\""+DEVICE_ID+"\",\"at\":\"now\",\"data\":{\"Temp\":\"10\"}}";
//String frame_json = "{\"protocol\":\"v2\"}";

  // Dump to "char array" and return.
  //   (mqtt.publish method does not works with "String" type, so it must be "casted" to "char array")
 // int frame_length = frame_json.length() + data_json.length() + 1;
  int frame_length = frame_json.length() + 1;
  // Serial.print("Largo Frame:");
   // Serial.println(frame_length);
    //Serial.println(frame_json);
  
  char frame_buffer[frame_length];
  frame_json.toCharArray(frame_buffer, frame_length);
  Serial.print("frame_buffer: ");
  Serial.println(frame_buffer);
 
  return frame_buffer;
}

void myframe(){ //By PQV ****************************************
 //t1 = sensorValor;  //     +++++++++ asignar a valor a publicar la medida del sensor
  
  String frame_json = "{\"protocol\":\"v2\",\"device\":\""+DEVICE_ID+"\",\"at\":\"now\",\"data\":{\"Temp\":\""+String(t1)+"\"}}";
  int frame_length = frame_json.length() + 1;
  // Serial.print("Largo Frame:");
  // Serial.println(frame_length);
  //Serial.println(frame_json);
  char frame_buffer[frame_length];
  frame_json.toCharArray(frame_buffer, frame_length);
  Serial.print("Publishing at "CARRIOTS_MQTT_TOPPIC ": ");
  Serial.println(frame_buffer);
  // Publish data frame. 
  if (mqtt_client.publish(CARRIOTS_APIKEY CARRIOTS_MQTT_TOPPIC, frame_buffer)) { // No comma between APIKEY and TOPPIC.
    Serial.println("Published.");
  } else {
    Serial.println("Failed publishing.");
  }
  Serial.println();
}

void setup() {

  // Open serial communications and wait for port to open:
  Serial.begin(9600);  
  Serial.println(DEVICE_ID);
 
 // while (!Serial) { // This check is only needed on the Leonardo:
 //   ; // wait for serial port to connect. Needed for Leonardo only
 // }
  // Start the Ethernet connection:
  if (Ethernet.begin(mac) == 0) {
    Serial.println("Failed to configure Ethernet using DHCP");
    // Try to congifure using IP address instead of DHCP:
    Ethernet.begin(mac, ip);
  } else {
    Serial.println("Ethernet configured using DHCP");
  }
  Serial.println();
  // give the Ethernet shield a second to initialize:
  delay(1000);
}

void loop() {
  
  // Connect to MQTT si no estubiese conectado
  if (!mqtt_client.connected()) {
    mqtt_connect();
  }
  
  // Read Temperature **************************
  //sensorValor = analogRead(TEMP_SENSOR); // Leemos el valor actual del pin analogo, este valor
  sensorValor = leeDatos();
// hacer el mapeo de las señales por cifras multiplicadas por 10 para
     // obtener decimales, pues la funcion map no recibe numeros flotantes
    // f1 = map( sensorValor * 1, 0, 1024, -200, 800 ); // convirtiendo a flotante
   //             t1 = 0.058 * sensorValor -23.6; // 13.75 - 7,3;
 //   t1 =  0.066 * sensorValor -29.96 ; // 13/06/2018
 //   t1 = 0.1285 * sensorValor -43.4 ;    //25/09/2018

// resistencia  220 ohm  con 4 a 20ma v0= 220*4/1000=0.88 v1= 200*20/1000=4.4
// existe una rlacion lineal 0-1024 digital  rep 0-5V anal  -> m = 204.8   y=204.8 * x
// voltage entrada de y(4.4)= 4.4*204.8= 901.1 (máx)->+40°C  y(0.88)= 0.88*204.8= 180.2 (min)->-10°C
//m = 40--10/880-176= 0,069358132  n = -22.5
// La pt100 a sido configurada para un rango de -10°C (4ma) a +40°C (20mA)
//  Y °C = 0,069358132 X -22.5
//[-22.5°C  [ -10°C , +40°C ]  +48.52°C] {Teorico[Pt100] ]

//t1 = 0.069358132 * sensorValor -22.5;
//t1= 0.05  * sensorValor -23.9;

// con una estrada de conversor de 4-20ma a 0-5V a 0-1024 a -10 a +40°C
// m = 5/1025 = 0,048828125    n = -10 este valor puede subir o bajar dependiendo
// de la fuente de alimentacion

//t1  =  0.048828125  * sensorValor - 10;
//t1 =   0.0490625  * sensorValor -24,950625;
// ajuste ya que al estar la USB la AI baja su tension
//  t1 =   0.26 *  sensorValor -94.12 - 23; 
 // t1 =  0.05 *  sensorValor -26.3;
 if(sensorValor > 600)  t1 =  0.01  *  sensorValor -1.09;
 else                   t1 =  0.062 *  sensorValor -31.42;

    //  el dato baja cuando esta conectado el usb por arduino
    
          //7,3  el dato baja cuando esta conectado el usb por arduino
                        // con una cifra decimal  + ajute de 18.4 compensatorio
Serial.print("sensorValor: ");
Serial.println(sensorValor ); //valor directo del sensor pt100
Serial.print("Temperatura °C: ");
Serial.println(t1); // Imprimimos la temperatura actual en el puerto serial

  // Send frame *************************************
 myframe();//este
  
  //mqtt_publish(get_frame());
//  delay(3000); // Espera 3 segundos
//delay(30000); // Espera 30 segundos
//delay(60000); // Espera 60 segundos
//delay(180000); // Espera 60 segundos x 3 
delay(175000); // Espera 2 min y 55 segundos 
}

 int leeDatos(){
    for( int i = 0; i < 10; i++){
      ave.push( analogRead(TEMP_SENSOR));
      delay(500);
    }
    float  suma = 0;
    int k = 0;
    float d1 = ave.mean() - ave.stddev() ;
    //Serial.print("d1: ");Serial.println( d1 ); 
    float d2 = ave.mean() +  ave.stddev() ;
    //Serial.print("d2: ");Serial.println( d2 ); 
    for(int i=0; i<10; i++){
      if(  d1 < ave.get(i) &&  ave.get(i) < d2){
        k++;
        suma = suma +  ave.get(i); 
      }
    }
    return (int) (suma / k);
  }
