package me.becomp.persistence.model.personal;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by sapun4ik on 23.04.2018.
 */
@Entity
@Table(name = "p_fact_budget")
public class PFactBudget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "report_date")
    private Date reportDate;

    @Column(name = "event_date")
    private Date eventDate;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String description;

    private String name;

    @Column(name = "path_file")
    private String pathFile;

    private int priority;

    @Digits(integer=19, fraction=4)
    private BigDecimal price;

    @ManyToOne()
    @JoinColumn(name = "from_p_account_id")
    private PAccount from;

    @ManyToOne()
    @JoinColumn(name = "to_p_account_id")
    private PAccount to;

    @ManyToOne()
    @JoinColumn(name = "p_user_id")
    private PUser pUser;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public PAccount getFrom() {
        return from;
    }

    public void setFrom(PAccount from) {
        this.from = from;
    }

    public PAccount getTo() {
        return to;
    }

    public void setTo(PAccount to) {
        this.to = to;
    }

    public PUser getpUser() {
        return pUser;
    }

    public void setpUser(PUser pUser) {
        this.pUser = pUser;
    }
}
