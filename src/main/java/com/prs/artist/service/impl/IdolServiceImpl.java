package com.prs.artist.service.impl;

import com.prs.artist.bean.idol.IdolInfo;
import com.prs.artist.bean.idol.IdolSearchReqMsg;
import com.prs.artist.bean.idol.IdolSearchRespMsg;
import com.prs.artist.constant.ErrorCode;
import com.prs.artist.datasource.entity.Idol;
import com.prs.artist.datasource.repository.IdolRepo;
import com.prs.artist.exeption.CustomException;
import com.prs.artist.service.AbstractService;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service("idolService")
@Scope("prototype")
@RequiredArgsConstructor
public class IdolServiceImpl extends AbstractService
{
	private static final Logger logger = LoggerFactory.getLogger(IdolServiceImpl.class);

	@Autowired
	private IdolRepo idolRepo;

	@Override
	protected IdolSearchReqMsg castReqMsg(Object reqMsg) { return (IdolSearchReqMsg) reqMsg; }

	@Override
	protected IdolSearchRespMsg castRespMsg(Object respMsg)
	{
		return (IdolSearchRespMsg) respMsg;
	}

	@Override
	protected IdolSearchRespMsg initRespMsg()
	{
		return new IdolSearchRespMsg();
	}

	@Override
	protected void logBegin(Object reqMsg)
	{
		// TODO add logging before process txn
	}

	@Override
	protected void validateRequestMessage(String serviceName, Object reqMsg) throws CustomException
	{
		IdolSearchReqMsg idolReq = castReqMsg(reqMsg);
		if(idolReq == null) {
			throw new CustomException(ErrorCode.E_10001, "request is not empty.");
		}

		if(idolReq.getRequestBody() == null) {
			throw new CustomException(ErrorCode.E_10001, "requestBody is not empty.");
		}

		if(StringUtils.isBlank(idolReq.getRequestBody().getName())) {
			throw new CustomException(ErrorCode.E_10001, "Name is not empty.");
		}
	}

	@Override
	protected void process(String serviceName, Object reqMsg, Object respMsg) throws CustomException, ParseException {
		IdolSearchReqMsg idolReq = castReqMsg(reqMsg);
		String name = idolReq.getRequestBody().getName();
		List<Idol> idolList = idolRepo.findByName(name);
		prepareIdolInfo(idolList, respMsg);
	}

	private void prepareIdolInfo(List<Idol> idolList, Object respMsg) throws ParseException {
		IdolSearchRespMsg idolSearchResp = castRespMsg(respMsg);
		List<IdolInfo> dataList = new ArrayList<>();
		for(Idol idol : idolList) {
			IdolInfo idolInfo = new IdolInfo();
			idolInfo.setId(idol.getId().getId());
			idolInfo.setName(idol.getName());
			idolInfo.setDateOfBirth(convertDateFormat(idol.getDateOfBirth()));
			idolInfo.setBandName(idol.getBandName());
			dataList.add(idolInfo);
		}
		idolSearchResp.setData(dataList);
	}

	private String convertDateFormat(Date dateVal) throws ParseException {
		LocalDateTime ldt = LocalDateTime.ofInstant(dateVal.toInstant(), ZoneId.systemDefault());
		return DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH).format(ldt);
	}

	@Override
	protected Object generateResponseSuccess(String serviceName, Object reqMsg, Object respMsg)
	{
		IdolSearchRespMsg IdolSearchRespMsg = castRespMsg(respMsg);
		IdolSearchRespMsg.setCode(ErrorCode.SUCCESS_CODE);
		IdolSearchRespMsg.setMessage(ErrorCode.SUCCESS_MSG);
		return IdolSearchRespMsg;
	}

	@Override
	protected Object generateResponseFail(Exception e, String serviceName, Object reqMsg, Object respMsg)
	{
		IdolSearchRespMsg IdolSearchRespMsg = castRespMsg(respMsg);
		IdolSearchRespMsg.setCode(ErrorCode.ERROR_500);
		IdolSearchRespMsg.setMessage(ErrorCode.ERROR_DEFAULT_MSG);
		return IdolSearchRespMsg;
	}

	@Override
	protected void logEnd(Object respMsg)
	{
		// TODO add logging after process txn
	}
	
}