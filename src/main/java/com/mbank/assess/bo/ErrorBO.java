package com.mbank.assess.bo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ErrorBO {

    private Integer status;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;
    
    @JsonInclude(Include.NON_NULL)
    private String error;

    @JsonInclude(Include.NON_NULL)
    private String[] errors;

    public ErrorBO(Integer status, String error) {
        this.status = status;
        this.timestamp = LocalDateTime.now();
        this.error = error;
    }
    
    public ErrorBO(Integer status, String[] errors) {
        this.status = status;
        this.timestamp = LocalDateTime.now();
        this.errors = errors;
    }

    public Integer getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

	public String getError() {
		return error;
	}

	public String[] getErrors() {
		return errors;
	}
    
}