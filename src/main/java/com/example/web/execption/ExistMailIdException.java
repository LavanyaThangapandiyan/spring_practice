package com.example.web.execption;

public class ExistMailIdException extends Exception{
	private static final long serialVersionUID = 1L;
		
	public ExistMailIdException(String message)
		{
			super(message);
			
		}
		
}
