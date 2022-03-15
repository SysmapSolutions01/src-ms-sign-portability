package br.com.sysmap.srcmssignportability.application.services;

import br.com.sysmap.srcmssignportability.application.ports.in.PortabilityService;
import br.com.sysmap.srcmssignportability.application.ports.out.PortabilityOpenFeign;
import br.com.sysmap.srcmssignportability.application.ports.out.PortabilityRepository;
import br.com.sysmap.srcmssignportability.domain.Portability;
import br.com.sysmap.srcmssignportability.framework.adapters.in.dtos.InputPortability;

public class PortabilityServiceImpl implements PortabilityService {

    private final PortabilityRepository portabilityRepository;
    private final PortabilityOpenFeign portabilityOpenFeign;

    public PortabilityServiceImpl(PortabilityRepository portabilityRepository, PortabilityOpenFeign portabilityOpenFeign) {
        this.portabilityRepository = portabilityRepository;
        this.portabilityOpenFeign = portabilityOpenFeign;
    }

    @Override
    public void callbackPortability(InputPortability inputPortability) {
        portabilityOpenFeign.updatePortabilityStatus(inputPortability);
    }

    @Override
    public Portability savePortability(Portability portability) {
        return portabilityRepository.save(portability);
    }
}
