package br.com.sysmap.srcmssignportability.application.ports.out;

import br.com.sysmap.srcmssignportability.domain.enums.PortabilityStatus;

import java.util.UUID;

public interface PortabilityOpenFeign {
    void updatePortabilityStatus(UUID portabilityId, PortabilityStatus portabilityStatus);
}
