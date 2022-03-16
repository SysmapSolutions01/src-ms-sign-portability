package br.com.sysmap.srcmssignportability.framework.adapters.config;

import br.com.sysmap.srcmssignportability.SrcMsSignPortabilityApplication;
import br.com.sysmap.srcmssignportability.application.ports.out.PortabilityOpenFeign;
import br.com.sysmap.srcmssignportability.application.ports.out.PortabilityRepository;
import br.com.sysmap.srcmssignportability.application.services.PortabilityServiceImpl;
import br.com.sysmap.srcmssignportability.domain.enums.PortabilityStatus;
import br.com.sysmap.srcmssignportability.framework.adapters.out.openfeign.PortabilityOpenfeignImpl;
import br.com.sysmap.srcmssignportability.framework.adapters.out.persistence.PortabilityRepositoryMongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
@ComponentScan(basePackageClasses = SrcMsSignPortabilityApplication.class)
public class ServiceConfig {
    @Bean
    PortabilityServiceImpl portabilityService(PortabilityRepository portabilityRepository, PortabilityOpenFeign portabilityOpenFeign){
        return new PortabilityServiceImpl(portabilityRepository, portabilityOpenFeign);
    }

    @Bean
    PortabilityOpenFeign portabilityOpenFeign() {
        return new PortabilityOpenfeignImpl();
    }
}
