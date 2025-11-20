package fr.epita.projet_paul_montagnac.repository;

import fr.epita.projet_paul_montagnac.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
