//package org.kizombadev.spring.demo.listener;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Configuration
//@Service
//public class KafkaTestTopicListener {
//
//    @KafkaListener(topics = "test-topic", groupId = "foo", containerFactory = "fooKafkaListenerContainerFactory")
//    public void listenGroupFoo(String message) {
//        System.out.println("Received Messasge in group 'foo': " + message);
//    }
//}
