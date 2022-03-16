package br.com.sysmap.srcmssignportability;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SrcMsSignPortabilityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SrcMsSignPortabilityApplication.class, args);
    }

}
