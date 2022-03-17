package br.com.sysmap.srcmssignportability.framework.adapters.config;

import br.com.sysmap.srcmssignportability.application.ports.out.PortabilityOpenFeign;
import br.com.sysmap.srcmssignportability.framework.adapters.out.openfeign.PortabilityOpenfeignImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenFeignConfig {
    @Bean
    PortabilityOpenFeign portabilityOpenFeign() {
        return new PortabilityOpenfeignImpl();
    }
}
