package com.rcasani.repository;

import com.rcasani.domain.Orden;
import com.rcasani.infraestructure.entity.OrdenEntity;
import com.rcasani.infraestructure.repository.OrdenJpaRepository;
import com.rcasani.repository.mapper.OrdenRepositoryMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrdenRepository {

    private final OrdenJpaRepository jpaRepository;
    private final OrdenRepositoryMapper mapper;

    public OrdenRepository(OrdenJpaRepository jpaRepository, OrdenRepositoryMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    public Orden save(Orden orden) {
        OrdenEntity entity = mapper.toEntity(orden);
        OrdenEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }
}
