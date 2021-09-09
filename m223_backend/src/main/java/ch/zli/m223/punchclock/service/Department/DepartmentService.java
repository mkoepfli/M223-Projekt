package ch.zli.m223.punchclock.service.Department;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.punchclock.domain.Department.Department;

@ApplicationScoped
public class DepartmentService {
    @Inject
    private EntityManager entityManager;

    public DepartmentService() {
    }

    @Transactional 
    public Department createDepartment(Department department) {
        entityManager.persist(department);
        return department;
    }

    @SuppressWarnings("unchecked")
    public List<Department> findAll() {
        var query = entityManager.createQuery("FROM Department");
        return query.getResultList();
    }
}
