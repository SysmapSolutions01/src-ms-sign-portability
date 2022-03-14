package br.com.sysmap.srcmssignportability.framework.adapters.config;

import br.com.sysmap.srcmssignportability.SrcMsSignPortabilityApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = SrcMsSignPortabilityApplication.class)
public class ServiceConfig {}
