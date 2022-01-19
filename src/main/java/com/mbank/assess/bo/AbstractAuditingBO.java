package com.mbank.assess.bo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public abstract class AbstractAuditingBO
        extends AbstractBO {

    private String modifiedBy;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedOn;

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(LocalDateTime modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

}
