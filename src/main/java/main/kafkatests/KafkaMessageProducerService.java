package main.kafkatests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class KafkaMessageProducerService {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaMessageConsumerService.class);

    @Autowired
	private KafkaTemplate<String, String> kafka;

    public void send(String topic,String msg) {
        kafka.send(topic, msg);
        LOG.info("Message produced {}", msg);
    }
}

