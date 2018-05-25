package me.becomp.persistence.model.personal;

import me.becomp.persistence.model.security.User;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by sapun4ik on 19.04.2018.
 */
@Entity
@Table(name = "p_period_planning")
public class PPeriodPlanning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne()
    @JoinColumn(name = "p_user_id")
    private PUser pUser;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Digits(integer=19, fraction=4)
    private BigDecimal count;

    @Column(name = "report_date")
    private Date reportDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PUser getpUser() {
        return pUser;
    }

    public void setpUser(PUser pUser) {
        this.pUser = pUser;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }
}
