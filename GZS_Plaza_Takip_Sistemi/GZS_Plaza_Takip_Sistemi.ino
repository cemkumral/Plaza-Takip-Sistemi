#include <LiquidCrystal.h>

LiquidCrystal lcd(8, 9, 4, 5, 6, 7);

int adminLed = 42;

int hareketPin = 53;
int hareketLed = 52;

int lm35Pin = A9;
int isiticiLed = 44;
int sogutucuLed = 45;

int dumanPin = A8;
int dumanBuzzer = 48;

void setup() {
  Serial.begin(9600);
  lcd.begin(16, 2);

  pinMode(hareketLed, OUTPUT);
  pinMode(hareketPin, INPUT);
  pinMode(dumanPin, INPUT);
  pinMode(dumanBuzzer, OUTPUT);
  pinMode(lm35Pin, INPUT);
  pinMode(isiticiLed, OUTPUT);
  pinMode(sogutucuLed, OUTPUT);
  pinMode(adminLed, OUTPUT);
}

void sicaklik() {

  int value = analogRead(lm35Pin);
  float ceviri = ((value / 1024.0) * 5000);
  int sicaklik = (ceviri / 11.5);
  //Serial.print("Scklk : ");
  Serial.print(sicaklik);
  Serial.print(";");
  lcd.setCursor(6, 0);
  lcd.print("Scklk=");
  lcd.print(sicaklik);
  lcd.println("C ");
  if (sicaklik > 34)
  {
    digitalWrite(sogutucuLed, HIGH);
    digitalWrite(isiticiLed, LOW);
  }
  else if (sicaklik < 31)
  {
    digitalWrite(isiticiLed, HIGH);
    digitalWrite(sogutucuLed, LOW);
  }
  else
  {
    digitalWrite(isiticiLed, LOW);
    digitalWrite(sogutucuLed, LOW);
  }
}

void hareket() {

  if (digitalRead(hareketPin) == HIGH)
  {
    //Serial.print("Hareket Degeri : ");
    Serial.print(digitalRead(hareketPin));
    Serial.print(";");
    digitalWrite(hareketLed, HIGH);
  }
  else {
    // Serial.print("Hareket Degeri : ");
    Serial.print(digitalRead(hareketPin));
    Serial.print(";");
    digitalWrite(hareketLed, LOW);
  }
}


void duman() {

  //Serial.print("Hava Kalitesi : ");
  Serial.print(analogRead(dumanPin));
  Serial.print(";");
  if (analogRead(dumanPin) > 380)
  {
    digitalWrite(dumanBuzzer, HIGH);
  }
  else
  {
    digitalWrite(dumanBuzzer, LOW);
  }
}

void loop() {
  String gelen = Serial.readString();

  if(gelen.equals("1"))
  {
    lcd.clear();
    lcd.setCursor(0, 0);
    lcd.print("Admin Alarmi!!!");
    digitalWrite(adminLed, HIGH);
    delay(1500);
  }
  //lcd.clear();
  lcd.setCursor(0, 0);
  lcd.print("-PTS-");
  digitalWrite(adminLed, LOW);
  sicaklik();
  duman();
  hareket();
  Serial.println("");
  lcd.setCursor(0, 1);
  lcd.print("Hava=");
  lcd.print(analogRead(dumanPin));
  lcd.print(" Harkt=");
  lcd.print(digitalRead(hareketPin));
  delay(1000);
}
