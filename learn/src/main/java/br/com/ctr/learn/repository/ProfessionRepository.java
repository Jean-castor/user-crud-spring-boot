package br.com.ctr.learn.repository;

import br.com.ctr.learn.entity.ProfessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfessionRepository extends JpaRepository<ProfessionEntity, UUID> {
}
