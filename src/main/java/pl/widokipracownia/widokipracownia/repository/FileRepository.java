package pl.widokipracownia.widokipracownia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.widokipracownia.widokipracownia.entity.File;

@Repository
public interface FileRepository extends JpaRepository<File, Integer> {
}
