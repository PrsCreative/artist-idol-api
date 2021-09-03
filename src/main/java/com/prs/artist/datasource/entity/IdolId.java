package com.prs.artist.datasource.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class IdolId implements Serializable
{
	private static final long serialVersionUID = 7099885646182047726L;

	@Column(name = "ID")
	private BigInteger id;

	public IdolId()
	{
	}

}
