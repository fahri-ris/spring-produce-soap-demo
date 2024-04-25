package demo.soap.repositories;

import demo.soap.models.Birthday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirthdayRepository extends JpaRepository<Birthday, Long> {
    Birthday findByFullNameIgnoreCase(String name);
}
