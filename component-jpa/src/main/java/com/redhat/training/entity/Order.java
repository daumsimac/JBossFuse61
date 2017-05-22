package com.redhat.training.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@Entity
@Table(schema="camel",name="orders")
@CsvRecord(separator=",",crlf="UNIX")
public class Order implements Serializable {

	private static final long serialVersionUID = -1918022935493323483L;

	@Id
	@DataField(pos=1)
	private int id;
	@DataField(pos=2)
	private String description;
	@DataField(pos=3)
	private double tax;
	@DataField(pos=4)
	private double price;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
