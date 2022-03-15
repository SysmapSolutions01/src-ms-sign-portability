package br.com.sysmap.srcmssignportability.application.ports.out;


import br.com.sysmap.srcmssignportability.framework.adapters.in.dtos.InputPortability;

public interface PortabilityOpenFeign {
    void updatePortabilityStatus(InputPortability inputPortability);
}
