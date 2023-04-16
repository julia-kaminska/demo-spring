package pl.kaminska.julia.demo.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kaminska.julia.demo.spring.model.entity.TranslationEntity;

@Repository
public interface TranslationRepository extends JpaRepository<TranslationEntity, Long> {
}
