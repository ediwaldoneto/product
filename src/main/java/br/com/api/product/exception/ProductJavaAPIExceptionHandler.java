package br.com.api.product.exception;

import br.com.api.product.dto.response.Response;
import com.fasterxml.jackson.core.JsonParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ServerErrorException;

@ControllerAdvice
public class ProductJavaAPIExceptionHandler<T> {

    private final Logger logger = LoggerFactory.getLogger("loggerExceptionHandler");

    @ExceptionHandler(value = {ProductException.class})
    protected ResponseEntity<Response<T>> handleProductNotFoundException(ProductException exception) {

        Response<T> response = new Response<>();
        response.addErrorMsgToResponse(exception.getMessage());
        logger.info(exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(value = {HttpMessageNotReadableException.class, JsonParseException.class})
    protected ResponseEntity<Response<T>> handleMessageNotReadableException(Exception exception) {

        Response<T> response = new Response<>();
        response.addErrorMsgToResponse(exception.getMessage());
        logger.info(exception.getMessage());

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
    }

    @ExceptionHandler(value = {ServerErrorException.class})
    protected ResponseEntity<Response<T>> handleAPIException(ServerErrorException exception) {

        Response<T> response = new Response<>();
        response.addErrorMsgToResponse(exception.getMessage());
        logger.info(exception.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    protected ResponseEntity<Response<T>> handleApiMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

        Response<T> response = new Response<>();
        response.addErrorMsgToResponse(exception.getMessage());
        logger.info(exception.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
