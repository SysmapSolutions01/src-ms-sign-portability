package br.com.sysmap.srcmssignportability.framework.adapters.in.consumer;

import br.com.sysmap.srcmssignportability.application.ports.in.KafkaConsumer;
import br.com.sysmap.srcmssignportability.application.ports.in.PortabilityService;
import br.com.sysmap.srcmssignportability.domain.Portability;
import br.com.sysmap.srcmssignportability.framework.adapters.in.dtos.PortabilityDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class KafkaConsumerImpl implements KafkaConsumer {

    private PortabilityService portabilityService;

    @Override
    @KafkaListener(topics = "${kafka.topic}", groupId = "group")
    public void listen(ConsumerRecord<String, String> payload) {
        log.info("Evento recebido, payload: " + payload.value());

        Portability portability = new Portability();
        BeanUtils.copyProperties(payload.value(), portability);
        
        this.portabilityService.savePortability(portability);
    }
}
