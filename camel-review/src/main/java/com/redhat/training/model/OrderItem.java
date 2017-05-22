package com.redhat.training.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="orderItem")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(schema="CAMEL",name="ORDER_ITEM")
@SequenceGenerator(name="orderItem",sequenceName="CAMEL.ORDER_ITEM_SEQ")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 2909797468939362690L;
	@Id
	@GeneratedValue(generator="orderItem",strategy=GenerationType.SEQUENCE)
	@XmlElement(name="id")
	private int id;
	@XmlElement(name="orderId")
	private int orderId;
	@XmlElement(name="description")
	private String description;
	@XmlElement(name="companyId")
	private int companyId;
	@XmlElement(name="price")
	private double price;
	@XmlElement(name="amount")
	private int amount;
	
}
