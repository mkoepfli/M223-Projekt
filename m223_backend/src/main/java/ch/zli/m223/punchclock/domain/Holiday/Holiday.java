package ch.zli.m223.punchclock.domain.Holiday;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long holidayId;

    @Column(nullable = false)
    private LocalDate start_date;

    @Column(nullable = false)
    private LocalDate end_date;

    public Long getId() {
        return holidayId;
    }

    public void setId(Long holidayId) {
        this.holidayId = holidayId;
    }

    public LocalDate getStartDate() {
        return start_date;
    }

    public void setStartDate(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEndDate() {
        return end_date;
    }

    public void setEndDate(LocalDate end_date) {
        this.end_date = end_date;
    }
}