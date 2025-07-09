package ru.hippon.wikimedia.consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WikimediaConsumer {
    // Получение сообщений
    @KafkaListener(topics = "${hippon.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeMsg(String msg) {
        log.info("Consuming the message {}", msg);
    }
}
