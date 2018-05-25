package me.becomp.persistence.model.personal;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

/**
 * Created by sapun4ik on 23.04.2018.
 */
@Entity
@Table(name = "p_account")
public class PAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Digits(integer=19, fraction=4)
    private BigDecimal balance;

    @ManyToOne()
    @JoinColumn(name = "p_user_id")
    private PUser pUser;

    @Column(name = "report_date")
    private Date reportDate;

    private String name;

    private boolean enabled;

    private boolean visible;

    private String code;

    @OneToMany(mappedBy = "from", cascade = CascadeType.ALL) //, orphanRemoval = true)
    private Collection<PFactBudget> fromFactBudgets;

    @OneToMany(mappedBy = "to", cascade = CascadeType.ALL) //, orphanRemoval = true)
    private Collection<PFactBudget> toFactBudgets;

    @OneToMany(mappedBy = "from", cascade = CascadeType.ALL) //, orphanRemoval = true)
    private Collection<PPlanBudget> fromPlanBudgets;

    @OneToMany(mappedBy = "to", cascade = CascadeType.ALL)//, orphanRemoval = true)
    private Collection<PPlanBudget> toPlanBudgets;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public PUser getpUser() {
        return pUser;
    }

    public void setpUser(PUser pUser) {
        this.pUser = pUser;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Collection<PFactBudget> getFromFactBudgets() {
        return fromFactBudgets;
    }

    public void setFromFactBudgets(Collection<PFactBudget> fromFactBudgets) {
        this.fromFactBudgets = fromFactBudgets;
    }

    public Collection<PFactBudget> getToFactBudgets() {
        return toFactBudgets;
    }

    public void setToFactBudgets(Collection<PFactBudget> toFactBudgets) {
        this.toFactBudgets = toFactBudgets;
    }

    public Collection<PPlanBudget> getFromPlanBudgets() {
        return fromPlanBudgets;
    }

    public void setFromPlanBudgets(Collection<PPlanBudget> fromPlanBudgets) {
        this.fromPlanBudgets = fromPlanBudgets;
    }

    public Collection<PPlanBudget> getToPlanBudgets() {
        return toPlanBudgets;
    }

    public void setToPlanBudgets(Collection<PPlanBudget> toPlanBudgets) {
        this.toPlanBudgets = toPlanBudgets;
    }
}
