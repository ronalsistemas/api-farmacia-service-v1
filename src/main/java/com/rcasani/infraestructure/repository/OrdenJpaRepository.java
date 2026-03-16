package com.rcasani.infraestructure.repository;

import com.rcasani.infraestructure.entity.OrdenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrdenJpaRepository extends JpaRepository<OrdenEntity, UUID> {
}
