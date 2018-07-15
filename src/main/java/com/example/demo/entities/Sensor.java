package com.example.demo.entities;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the sensor database table.
 * 
 */
@Entity
@NamedQuery(name="Sensor.findAll", query="SELECT s FROM Sensor s")
public class Sensor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private int doamdat;

	private int humidity;

	private int temperature;

	public Sensor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDoamdat() {
		return this.doamdat;
	}

	public void setDoamdat(int doamdat) {
		this.doamdat = doamdat;
	}

	public int getHumidity() {
		return this.humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public int getTemperature() {
		return this.temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

}