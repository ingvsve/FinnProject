package com.example;


import org.checkerframework.checker.units.qual.min;

import tests.eiendomsTest;
import tests.reiseTest;


public class App {
    public static void main(String[] args) {
        eiendomsTest minEiendomsTest = new eiendomsTest();
        minEiendomsTest.setUp();
        minEiendomsTest.eiendom();
        minEiendomsTest.tearDown();
        
        /*reiseTest minReisetest = new reiseTest();
        minReisetest.setUp();
        minReisetest.testReiseResultat();
        minReisetest.tearDown();*/
    }
}
