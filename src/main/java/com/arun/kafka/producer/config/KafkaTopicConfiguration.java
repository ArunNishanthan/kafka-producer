package com.arun.kafka.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public NewTopic high_Topic() {
        return TopicBuilder.name("High_Topic")
                .partitions(5)
                     .build();
    }

    @Bean
    public NewTopic medium_topic() {
        return TopicBuilder.name("Medium_topic")
                .partitions(3)
                .build();
    }

    @Bean
    public NewTopic low_topic() {
        return TopicBuilder.name("Low_topic")
                .partitions(1)
                .build();
    }


}