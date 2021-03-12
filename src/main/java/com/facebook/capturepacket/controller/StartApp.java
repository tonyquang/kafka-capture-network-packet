package com.facebook.capturepacket.controller;

import com.facebook.capturepacket.services.ProxyServer;
import com.facebook.capturepacket.services.StartKafka;
import lombok.extern.slf4j.Slf4j;



@Slf4j
public class StartApp {
    StartKafka startKafka;

    ProxyServer startProxyServer;

    public void startApp(){
        startKafka = new StartKafka();
        startProxyServer = new ProxyServer();
        startKafka.start();

        log.info("Waiting 15s before starting proxy server....");

        try {
            Thread.currentThread().sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startProxyServer.start();
    }

}
