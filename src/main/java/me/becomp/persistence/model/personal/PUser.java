package me.becomp.persistence.model.personal;

import me.becomp.persistence.model.security.User;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by sapun4ik on 19.04.2018.
 */
@Entity
@Table(name = "p_user")
public class PUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "pUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<PPeriodPlanning> plannings;

    @OneToMany(mappedBy = "pUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private  Collection<PAccount> accounts;

    @OneToMany(mappedBy = "pUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private  Collection<PFactBudget> factBudgets;

    @OneToMany(mappedBy = "pUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private  Collection<PPlanBudget> planBudgets;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pUser")
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Collection<PPeriodPlanning> getPlannings() {
        return plannings;
    }

    public void setPlannings(Collection<PPeriodPlanning> plannings) {
        this.plannings = plannings;
    }

    public Collection<PAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(Collection<PAccount> accounts) {
        this.accounts = accounts;
    }

    public Collection<PFactBudget> getFactBudgets() {
        return factBudgets;
    }

    public void setFactBudgets(Collection<PFactBudget> factBudgets) {
        this.factBudgets = factBudgets;
    }

    public Collection<PPlanBudget> getPlanBudgets() {
        return planBudgets;
    }

    public void setPlanBudgets(Collection<PPlanBudget> planBudgets) {
        this.planBudgets = planBudgets;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
