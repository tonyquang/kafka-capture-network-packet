package com.facebook.capturepacket.services;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Slf4j
public class ReadStream implements Runnable {

    String name;
    InputStream is;
    Thread thread;

    public ReadStream(String name, InputStream is) {
        this.name = name;
        this.is = is;
    }

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        try {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            while (true) {
                String s = br.readLine();
                if (s == null) {
                    break;
                }
               log.info("[" + name + "] " + s);
            }
            is.close();
        } catch (Exception ex) {
            log.error("Problem reading stream " + name + "... :" + ex);
            ex.printStackTrace();
        }
    }
}