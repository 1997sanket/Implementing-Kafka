package com.updownftw.producer.controller;

import com.updownftw.producer.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    private KafkaTemplate<String, Book> kafkaTemplate;


    private static final String TOPIC = "first_topic";

    @PostMapping("/publish")
    public String createBook(@RequestBody Book book) {
        kafkaTemplate.send(TOPIC, book);
        return "Published Successfully";
    }
}
