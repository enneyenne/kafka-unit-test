package main.kafkatests;

import org.apache.kafka.clients.consumer.*;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.*;


@Service
public class GetWatchersService {
    Consumer<String, String> consumer;

    public GetWatchersService(ConsumerFactory<String, String> consumerFactory) {
        consumer = consumerFactory.createConsumer("group-for-online","reader");
        consumer.subscribe(Arrays.asList("online"));
    }

    public List<String> getAll(){
        List<String> res= new ArrayList<>();
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
        for (ConsumerRecord<String, String> record : records) {
            System.out.println(record.key());
            res.add(record.value());
        }
        return res;
    }
}