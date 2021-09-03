package com.prs.artist.service;

import java.net.InetAddress;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public abstract class AbstractService
{
	private static final Logger logger = LoggerFactory.getLogger(AbstractService.class);
	private String serviceName;
	private Object reqMsg;
	private Object respMsg;
	
	protected abstract Object castReqMsg(Object reqMsg);
	protected abstract Object castRespMsg(Object respMsg);
	protected abstract Object initRespMsg();
	protected abstract void logBegin(Object reqMsg);
	protected abstract void logEnd(Object respMsg);

	protected abstract void validateRequestMessage(String serviceName, Object reqMsg) throws Exception;
	protected abstract void process(String serviceName, Object reqMsg, Object respMsg) throws Exception;
	protected abstract Object generateResponseSuccess(String serviceName, Object reqMsg, Object respMsg);
	protected abstract Object generateResponseFail(Exception e, String serviceName, Object reqMsg, Object respMsg);

	
	public Object execute(Object reqMsg, HttpServletRequest request, String serviceName)
	{
		final Date startDate = Calendar.getInstance().getTime();
		this.serviceName = serviceName;
		
		UUID uuid = UUID.randomUUID();
		String status = "FAIL";
		
		try {
			this.reqMsg = reqMsg;
			this.respMsg = initRespMsg();
			validateRequestMessage(serviceName, reqMsg);
			if (logger.isDebugEnabled())
				logger.info("execute :: validateRequestMessage success.");

			process(serviceName, reqMsg, respMsg);
			if (logger.isDebugEnabled())
				logger.info("execute :: process success.");
			
			respMsg = generateResponseSuccess(serviceName, reqMsg, respMsg);
			status = "SUCCESS";
		} catch (Exception e) {
			logger.error("execute :: Exception message={}", e.getMessage(), e);
			respMsg = generateResponseFail(e, serviceName, reqMsg, respMsg);
		} finally {

			long responseTime = System.currentTimeMillis() - startDate.getTime();
			if (logger.isInfoEnabled())
				logger.info("execute :: serviceName={} respTimes={}, respMsg={}", serviceName, responseTime, (respMsg != null ? respMsg.toString() : respMsg));

			MDC.clear();
		}

		return respMsg;
	}
	
	
	public String getServiceName() {
		return serviceName;
	}
	
	public Object getReqMsg() {
		return reqMsg;
	}
	
	public Object getRespMsg() {
		return respMsg;
	}

}