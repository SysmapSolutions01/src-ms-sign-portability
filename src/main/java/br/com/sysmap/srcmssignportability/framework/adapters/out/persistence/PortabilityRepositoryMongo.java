package br.com.sysmap.srcmssignportability.framework.adapters.out.persistence;

import br.com.sysmap.srcmssignportability.domain.Portability;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortabilityRepositoryMongo extends MongoRepository<Portability, String> { }
