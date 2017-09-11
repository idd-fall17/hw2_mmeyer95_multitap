package com.example.androidthings.myproject;

import com.google.android.things.pio.Gpio;

/**
 * Template for IDD Fall 2017 HW2 (text entry device)
 * Created by bjoern on 9/5/17.
 */


public class Hw2TemplateApp extends SimplePicoPro {

    //initiallize global variables
    long previousTime=0;
    int previousButton=0;
    int buttons=-1;
    char currentLetter=' ';
    int currentChar=-1;
    //Create letter array based on buttons & # times pressed
    char letters[][]={{'A','B','C',' '},{'D','E','F',' '},{'G','H','I',' '},{'J','K','L',' '},{'M','N','O',' '},{'P','Q','R','S'},{'T','U','V',' '},{'W','X','Y','Z'}};

    @Override
    public void setup() {
        //set 9 GPIOs to input
        pinMode(GPIO_128, Gpio.DIRECTION_IN); //This will be ABC
        setEdgeTrigger(GPIO_128, Gpio.EDGE_BOTH);

        pinMode(GPIO_39, Gpio.DIRECTION_IN); //This will be DEF
        setEdgeTrigger(GPIO_39, Gpio.EDGE_BOTH);

        pinMode(GPIO_37, Gpio.DIRECTION_IN); //This will be GHI
        setEdgeTrigger(GPIO_37, Gpio.EDGE_BOTH);

        pinMode(GPIO_35, Gpio.DIRECTION_IN); //This will be JKL
        setEdgeTrigger(GPIO_35, Gpio.EDGE_BOTH);

        pinMode(GPIO_34, Gpio.DIRECTION_IN); //This will be MNO
        setEdgeTrigger(GPIO_34, Gpio.EDGE_BOTH);

        pinMode(GPIO_33, Gpio.DIRECTION_IN); //This will be PQRS
        setEdgeTrigger(GPIO_33, Gpio.EDGE_BOTH);

        pinMode(GPIO_32, Gpio.DIRECTION_IN); //This will be TUV
        setEdgeTrigger(GPIO_32, Gpio.EDGE_BOTH);

        pinMode(GPIO_10, Gpio.DIRECTION_IN); //This will be WYZ
        setEdgeTrigger(GPIO_10, Gpio.EDGE_BOTH);

        pinMode(GPIO_172, Gpio.DIRECTION_IN); //This will be space
        setEdgeTrigger(GPIO_172, Gpio.EDGE_BOTH);
    }

    @Override
    public void loop() {
        //see how long it has been since a button was pressed
        //if there is a pause, print the character
        long currentTime=millis();
        long diff=currentTime-previousTime;
        if (diff>400 && previousTime!=0) {
            buttons=-1;
            previousTime=0;
            currentChar=-1;
            printCharacterToScreen(currentLetter);
        }
    }

    @Override
    void digitalEdgeEvent(Gpio pin, boolean value) {
        println("digitalEdgeEvent" + pin + ", " + value);
        // when 128 goes from LOW to HIGH
        // this is on button button release for pull-up resistors
        if (pin == GPIO_128 && value == HIGH) {
            previousTime =millis();
            buttons=0;
            currentChar=currentChar+1;
            currentLetter=letters[buttons][currentChar];
        }
        //when 39 goes from LOW to HIGH
        else if (pin == GPIO_39 && value == HIGH) {
            previousTime =millis();
            buttons=1;
            currentChar=currentChar+1;
            currentLetter=letters[buttons][currentChar];
        }
        //when 37 goes from LOW to HIGH
        else if (pin == GPIO_37 && value == HIGH) {
            previousTime = millis();
            buttons=2;
            currentChar=currentChar+1;
            currentLetter=letters[buttons][currentChar];
        }
        //when 35 goes from LOW to HIGH
        else if (pin == GPIO_35 && value == HIGH) {
            previousTime = millis();
            buttons=3;
            currentChar=currentChar+1;
            currentLetter=letters[buttons][currentChar];
        }
        //when 34 goes from LOW to HIGH
        else if (pin == GPIO_34 && value == HIGH) {
            previousTime = millis();
            buttons=4;
            currentChar=currentChar+1;
            currentLetter=letters[buttons][currentChar];
        }
        //when 33 goes from LOW to HIGH
        else if (pin == GPIO_33 && value == HIGH) {
            previousTime = millis();
            buttons=5;
            currentChar=currentChar+1;
            currentLetter=letters[buttons][currentChar];
        }
        //when 32 goes from LOW to HIGH
        else if (pin == GPIO_32 && value == HIGH) {
            previousTime = millis();
            buttons=6;
            currentChar=currentChar+1;
            currentLetter=letters[buttons][currentChar];
        }
        //when 10 goes from LOW to HIGH
        else if (pin == GPIO_10 && value == HIGH) {
            previousTime = millis();
            buttons=7;
            currentChar=currentChar+1;
            currentLetter=letters[buttons][currentChar];
        }
        //when 172 goes from LOW to HIGH
        else if (pin == GPIO_172 && value == HIGH) {
            printCharacterToScreen(' ');
        }
    }
}



