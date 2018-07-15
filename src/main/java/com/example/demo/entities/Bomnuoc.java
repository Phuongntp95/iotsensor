package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the bomnuoc database table.
 * 
 */
@Entity
@NamedQuery(name="Bomnuoc.findAll", query="SELECT b FROM Bomnuoc b")
public class Bomnuoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private int switchnuoc;

	public Bomnuoc() {
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

	public int getSwitchnuoc() {
		return this.switchnuoc;
	}

	public void setSwitchnuoc(int switchnuoc) {
		this.switchnuoc = switchnuoc;
	}

}