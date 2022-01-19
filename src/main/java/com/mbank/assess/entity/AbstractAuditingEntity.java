package com.mbank.assess.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public abstract class AbstractAuditingEntity
        extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "modifiedBy", length = 50)
    private String modifiedBy;

    @UpdateTimestamp
    @Column(name = "modifiedOn", insertable = false)
    private Timestamp modifiedOn;

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Timestamp getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Timestamp modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

}
