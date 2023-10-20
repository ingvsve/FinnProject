package com.example;


import tests.reiseTest;


public class App {
    public static void main(String[] args) {
        reiseTest minReisetest = new reiseTest();
        minReisetest.setUp();
        minReisetest.testReiseResultat();
        minReisetest.tearDown();
    }
}
