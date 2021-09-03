package com.prs.artist.bean.idol;

import lombok.Data;
import java.util.List;

@Data
public class IdolSearchRespMsg
{
	private String code;
	private String message;
	private List<IdolInfo> data;

}