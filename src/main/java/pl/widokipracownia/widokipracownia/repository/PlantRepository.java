package pl.widokipracownia.widokipracownia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.widokipracownia.widokipracownia.entity.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer> {
}
