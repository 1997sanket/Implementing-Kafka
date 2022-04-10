package com.updownftw.consumer;

import com.updownftw.consumer.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(groupId = "G1", topics = "first_topic")
    public void consume(Book book) {
        log.info(book.toString());
    }
}
