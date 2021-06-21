/*********************************************************************************************
 * Description    : It is an class that catches various Exceptions arises from controller
                    to display the Exception messages.
 
 *@ControllerAdvice--It allows to handle exceptions across the whole application in 
                     one global handling component.
                     
* @ExceptionHandler--For handling exceptions in specific handler classes and/or handler methods. 
 *********************************************************************************************/
package com.salon.advices;

import java.time.LocalDateTime;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler 
{
	//Resource Not Exception
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) 
    {
         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    //Default Exception
	 @ExceptionHandler(Exception.class) 
	 public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) 
	 { 
		  ErrorDetails  errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),request.getDescription(false)); 
	      return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR); 
	 }
	 
	//MethodArgumentNotValidException----for Validation Errors
	  @ExceptionHandler(MethodArgumentNotValidException.class)
	  public ResponseEntity<?> customValidationErrorHandling(MethodArgumentNotValidException exception){
		  ErrorDetails  errorDetails = new ErrorDetails(LocalDateTime.now(),"Validation Error",exception.getBindingResult().getFieldError().getDefaultMessage());
		  return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
	  }
}