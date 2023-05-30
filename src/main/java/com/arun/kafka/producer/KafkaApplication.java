package com.arun.kafka.producer;

import com.arun.kafka.producer.service.KafKaProducerService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@AllArgsConstructor
public class KafkaApplication {

	private final KafKaProducerService producerService;

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

	@PostConstruct
	void init(){
		ExecutorService executor = Executors.newFixedThreadPool(10);
		executor.submit(() -> {
			for (int i = 0; i < 100 ; i++) {
				producerService.sendMessage("High_Topic message "+i, "High_Topic");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		});

		executor.submit(() -> {
			for (int i = 0; i < 100 ; i++) {
				producerService.sendMessage(" Medium_Topic message "+i, "Medium_Topic");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		});


		executor.submit(() -> {
			for (int i = 0; i < 100000 ; i++) {
				producerService.sendMessage("Low_Topic message "+i, "Low_Topic");
			}
		});
	}

}
