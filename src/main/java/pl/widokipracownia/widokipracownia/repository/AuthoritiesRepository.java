package pl.widokipracownia.widokipracownia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.widokipracownia.widokipracownia.user.Authority;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authority, Long> {

    Authority findByName(String name);
}
