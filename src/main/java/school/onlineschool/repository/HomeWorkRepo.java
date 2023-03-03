package school.onlineschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import school.onlineschool.models.HomeWork;

public interface HomeWorkRepo extends JpaRepository<HomeWork, Long> {
}
