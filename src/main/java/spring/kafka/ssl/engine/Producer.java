package spring.kafka.ssl.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Component
public class Producer {
	
	@Value("${kafka.topic}")
	private String TOPIC;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String message) {
		log.info(String.format("#### -> Producing message -> %s", message));
		this.kafkaTemplate.send(TOPIC, message);
	}
}