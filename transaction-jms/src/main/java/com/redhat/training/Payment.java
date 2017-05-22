package com.redhat.training;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "from",
    "to",
    "amount"
})
@XmlRootElement(name = "Payment")
public class Payment implements Serializable{

    @XmlElement(required = true)
    protected String from;
    @XmlElement(required = true)
    protected String to;
    protected float amount;

    public String getFrom() {
        return from;
    }

    public void setFrom(String value) {
        this.from = value;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String value) {
        this.to = value;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float value) {
        this.amount = value;
    }

}
