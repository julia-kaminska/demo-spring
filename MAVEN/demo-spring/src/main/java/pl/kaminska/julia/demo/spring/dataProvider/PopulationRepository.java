package pl.kaminska.julia.demo.spring.dataProvider;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PopulationRepository extends JpaRepository<PopulationEntity, Long> {
}
