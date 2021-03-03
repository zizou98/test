package com.example.test.exception;

import java.util.Date;

public class ErrorDetails {
    private Date timesamp;
    private String message;
    private String detais;

    public ErrorDetails(Date timesamp, String message, String detais) {
        super();
        this.timesamp = timesamp;
        this.message = message;
        this.detais = detais;
    }

    public Date getTimesamp() {
        return timesamp;
    }

    public void setTimesamp(Date timesamp) {
        this.timesamp = timesamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetais() {
        return detais;
    }

    public void setDetais(String detais) {
        this.detais = detais;
    }


}
