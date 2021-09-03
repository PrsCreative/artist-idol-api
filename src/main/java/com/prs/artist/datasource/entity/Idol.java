package com.prs.artist.datasource.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "IDOL")
public class Idol implements Serializable
{
	private static final long serialVersionUID = -5536887857246462263L;

	@EmbeddedId
	private IdolId id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DATE_OF_BIRTH")
	private Date dateOfBirth;

	@Column(name = "BAND_NAME")
	private String bandName;
}
