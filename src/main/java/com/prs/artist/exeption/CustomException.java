package com.prs.artist.exeption;

public class CustomException extends Exception
{
	private static final long serialVersionUID = 1L;

	protected final String statusCode;
	protected final String statusDesc;
	protected final Throwable throwable;

	public CustomException(String statusCode, String statusDesc)
	{
		super(statusDesc);
		this.statusCode = statusCode;
		this.statusDesc = statusDesc;
		this.throwable = null;
	}

	public CustomException(String statusCode, String statusDesc, Throwable throwable)
	{
		super(statusDesc);
		this.statusCode = statusCode;
		this.statusDesc = statusDesc;
		this.throwable = throwable;
	}

	public String getStatusCode()
	{
		return statusCode;
	}

	public String getStatusDesc()
	{
		return statusDesc;
	}

	public Throwable getThrowable()
	{
		return throwable;
	}

	@Override
	public String getMessage()
	{
		return "statusCd=" + statusCode + ", statusDesc=" + statusDesc;
	}

}