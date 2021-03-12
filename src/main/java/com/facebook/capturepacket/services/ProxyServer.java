package com.facebook.capturepacket.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


@Slf4j
public class ProxyServer extends Thread {

    public ProxyServer() {
        super("Server Thread");
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            Socket socket;
            log.info("Proxy server start on 127.0.0.1:9999, waiting for connection...");

            while ((socket = serverSocket.accept()) != null) {
                (new Handler(socket)).start();
            }

        } catch (IOException e) {
           log.error("Start server error: ", e);
        }
    }

}
