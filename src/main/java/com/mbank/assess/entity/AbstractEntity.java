package com.mbank.assess.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;

@MappedSuperclass
public abstract class AbstractEntity
        implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "createdBy", nullable = false, length = 50)
    private String createdBy;

    @CreationTimestamp
    @Column(name = "createdOn")
    private Timestamp createdOn;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

}
