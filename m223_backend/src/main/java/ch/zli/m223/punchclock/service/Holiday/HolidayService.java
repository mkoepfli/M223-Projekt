package ch.zli.m223.punchclock.service.Holiday;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.punchclock.domain.Holiday.Holiday;

@ApplicationScoped
public class HolidayService {
    @Inject
    private EntityManager entityManager;

    public HolidayService() {
    }

    @Transactional 
    public Holiday createHoliday(Holiday holiday) {
        entityManager.persist(holiday);
        return holiday;
    }

    @SuppressWarnings("unchecked")
    public List<Holiday> findAll() {
        var query = entityManager.createQuery("FROM Holiday");
        return query.getResultList();
    }
}
