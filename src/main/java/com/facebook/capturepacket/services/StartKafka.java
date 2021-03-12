package com.facebook.capturepacket.services;

import com.facebook.capturepacket.configuration.Constant;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;


@Slf4j
public class StartKafka extends Thread{

    @Override
    public void run() {
        startZookeeper();
        log.info("Waiting 10s before start kafka Server");
        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startKafkaServer();
    }

    private void startZookeeper(){
        log.info("Starting Zookeeper...");
        new Thread(new Runnable() {
            @Override
            public void run() {
               String cmd = prepareStartZookeeperCommandLine();
                System.out.println(cmd);
               executeCommandLine(cmd, "zookeeper");
            }
        }).start();
    }

    private void startKafkaServer(){
        log.info("Starting Kafka Server...");
        new Thread(new Runnable() {
            @Override
            public void run() {
                String cmd = prepareStartKafkaServerCommandLine();
                executeCommandLine(cmd, "kafka server");
            }
        }).start();
    }


    private void executeCommandLine(String cmd, String serviceName){
        Process p = null;
        try {
            p = Runtime.getRuntime().exec(cmd);
            ReadStream s1 = new ReadStream("stdin", p.getInputStream());
            ReadStream s2 = new ReadStream("stderr", p.getErrorStream());
            s1.start();
            s2.start();
            p.waitFor();
        } catch (IOException e) {
            log.error("Execute command start "+serviceName+" failed: "+e);
        } catch (InterruptedException e) {
            log.error("Execute command start "+serviceName+" failed: "+e);
        } finally {
            if (p != null) {
                p.destroy();
            }
        }
    }

    private String prepareStartZookeeperCommandLine(){
        return "\""+Constant.SystemDefault.CURRENT_DIR
                +Constant.KafkaStartCommandLine.ZOOKEEPER_FILE+"\""
                +" "
                +"\""+Constant.SystemDefault.CURRENT_DIR
                +Constant.KafkaStartCommandLine.ZOOKEEPER_CONFIG_FILE+"\"";

    }

    private String prepareStartKafkaServerCommandLine(){
        return "\""+Constant.SystemDefault.CURRENT_DIR
                +Constant.KafkaStartCommandLine.KAFKA_SERVER_FILE+"\""
                +" "
                +"\""+Constant.SystemDefault.CURRENT_DIR
                +Constant.KafkaStartCommandLine.KAFKA_SERVER_CONFIG_FILE+"\"";

    }

}
