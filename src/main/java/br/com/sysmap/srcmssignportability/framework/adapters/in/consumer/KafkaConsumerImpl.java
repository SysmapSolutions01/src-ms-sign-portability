package br.com.sysmap.srcmssignportability.framework.adapters.in.consumer;

import br.com.sysmap.srcmssignportability.application.ports.in.KafkaConsumer;
import br.com.sysmap.srcmssignportability.application.ports.in.PortabilityService;
import br.com.sysmap.srcmssignportability.domain.Portability;
import br.com.sysmap.srcmssignportability.framework.adapters.in.dtos.InputPortability;
import br.com.sysmap.srcmssignportability.framework.adapters.in.dtos.PortabilityDTO;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class KafkaConsumerImpl implements KafkaConsumer {

    private PortabilityService portabilityService;

    @Override
    @KafkaListener(
            topics = "${kafka.topic}",
            groupId = "${kafka.group-id}"
    )
    public void listen(ConsumerRecord<String, String> payload) {
        log.info("Evento recebido, payload: " + payload.value());

        var gson = new Gson();
        InputPortability input = gson.fromJson(payload.value(), InputPortability.class);
        Portability portability = new Portability();
        BeanUtils.copyProperties(input, portability);
        BeanUtils.copyProperties(input.getPortability(), portability);
        portability.setPortabilityId(input.getPortability().getPortabilityId());
        log.warn("ID: " + portability.getPortabilityId());
        this.portabilityService.savePortability(portability);
    }
}
