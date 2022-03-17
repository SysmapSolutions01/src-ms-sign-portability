package br.com.sysmap.srcmssignportability.application.services;

import br.com.sysmap.srcmssignportability.application.ports.in.PortabilityService;
import br.com.sysmap.srcmssignportability.application.ports.out.PortabilityOpenFeign;
import br.com.sysmap.srcmssignportability.application.ports.out.PortabilityRepository;
import br.com.sysmap.srcmssignportability.domain.Portability;
import br.com.sysmap.srcmssignportability.domain.enums.PortabilityStatus;
import br.com.sysmap.srcmssignportability.domain.enums.TelephoneCompany;

public class PortabilityServiceImpl implements PortabilityService {

    private final PortabilityRepository portabilityRepository;
    private final PortabilityOpenFeign portabilityOpenFeign;

    public PortabilityServiceImpl(PortabilityRepository portabilityRepository, PortabilityOpenFeign portabilityOpenFeign) {
        this.portabilityRepository = portabilityRepository;
        this.portabilityOpenFeign = portabilityOpenFeign;
    }

    @Override
    public void callbackPortability(Portability portability) {
        portabilityOpenFeign.updatePortabilityStatus(portability.getPortabilityId(), validatePortability(portability));
    }

    @Override
    public Portability savePortability(Portability portability) {
        return portabilityRepository.save(portability);
    }

    private PortabilityStatus validatePortability(Portability portability) {
        if (portability.getNumber().length() == 9 && portability.getSource().equals(TelephoneCompany.VIVO)
        && !portability.getTarget().equals(TelephoneCompany.VIVO)) {
            return PortabilityStatus.PORTADO;
        }
        return PortabilityStatus.NAO_PORTADO;
    }


}
