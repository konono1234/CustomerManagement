package com.customer.error;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

public class WebExceptionHandler {

  private static final Logger LOG = LoggerFactory.getLogger(WebExceptionHandler.class);

  @ExceptionHandler(ApplicationException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public String handleApplicationException(ApplicationException exception) {

    LOG.error("handleApplicationException", exception);

    return "error/general";
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public String handleMethodArgumenttypeMismatchException(
      MethodArgumentTypeMismatchException exception) {

    LOG.error("handleMethodArgumentTypeMismatchException", exception);

    return "error/404";

  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public String handleException(Exception exception) {

    LOG.error("handleException", exception);

    return "error/general";
  }

}
