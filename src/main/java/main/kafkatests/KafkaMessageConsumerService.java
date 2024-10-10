package main.kafkatests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageConsumerService {

	private static final Logger LOG = LoggerFactory.getLogger(KafkaMessageConsumerService.class);

	@KafkaListener(topics = {"registrations", "online"})
	public void onMessage(@Payload String msg,
		@Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
		@Header(KafkaHeaders.RECEIVED_PARTITION) Integer partition,
		@Header(KafkaHeaders.OFFSET) Long offset) {

		LOG.info("Message consumed {}", msg);
		LOG.info("Message offset {}", offset);

	}

}

