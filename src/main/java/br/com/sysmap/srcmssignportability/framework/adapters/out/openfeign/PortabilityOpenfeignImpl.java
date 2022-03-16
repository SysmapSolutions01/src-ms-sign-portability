package br.com.sysmap.srcmssignportability.framework.adapters.out.openfeign;

import br.com.sysmap.srcmssignportability.application.ports.out.PortabilityOpenFeign;
import br.com.sysmap.srcmssignportability.domain.enums.PortabilityStatus;
import br.com.sysmap.srcmssignportability.framework.adapters.out.dtos.PortabilityFeignClientDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class PortabilityOpenfeignImpl implements PortabilityOpenFeign {

    @Autowired
    private PortabilityFeignClient portabilityFeignClient;

    @Override
    public void updatePortabilityStatus(UUID portabilityId, PortabilityStatus portabilityStatus) {
        portabilityFeignClient.update(portabilityId, new PortabilityFeignClientDTO(portabilityStatus));
    }
}
