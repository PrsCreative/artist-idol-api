package com.prs.artist.bean.idol;

import lombok.Data;

import java.math.BigInteger;

@Data
public class IdolInfo
{
	private BigInteger id;
	private String name;
	private String dateOfBirth;
	private String bandName;

}