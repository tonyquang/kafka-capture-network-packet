package com.facebook.capturepacket.controller;

import com.facebook.capturepacket.services.ProxyServer;
import lombok.extern.slf4j.Slf4j;



@Slf4j
public class StartApp {

    ProxyServer startProxyServer;

    public void startApp(){
        startProxyServer = new ProxyServer();

        log.info("Waiting 15s before starting proxy server....");

        try {
            Thread.currentThread().sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startProxyServer.start();
    }

}
