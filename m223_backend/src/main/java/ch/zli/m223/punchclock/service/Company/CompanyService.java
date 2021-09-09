package ch.zli.m223.punchclock.service.Company;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.punchclock.domain.Company.Company;

@ApplicationScoped
public class CompanyService {
    @Inject
    private EntityManager entityManager;

    public CompanyService() {
    }

    @Transactional 
    public Company createCompany(Company company) {
        entityManager.persist(company);
        return company;
    }

    @SuppressWarnings("unchecked")
    public List<Company> findAll() {
        var query = entityManager.createQuery("FROM Company");
        return query.getResultList();
    }
}
