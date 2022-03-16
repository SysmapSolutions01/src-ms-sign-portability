package br.com.sysmap.srcmssignportability.framework.adapters.out.openfeign;

import br.com.sysmap.srcmssignportability.framework.adapters.out.dtos.PortabilityFeignClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient(name = "src-ms-portability", url = "http://localhost:8080")
public interface PortabilityFeignClient {
    @PutMapping(value = "/portability/{portabilityId}", produces = "application/json", consumes = "application/json")
    String update(
            @PathVariable UUID portabilityId,
            @RequestBody PortabilityFeignClientDTO portabilityFeignClientDTO);
}
