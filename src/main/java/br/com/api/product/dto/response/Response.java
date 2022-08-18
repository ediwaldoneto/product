package br.com.api.product.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {

    private T data;
    private Object errors;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Object getErrors() {
        return errors;
    }

    public void setErrors(Object errors) {
        this.errors = errors;
    }

    public void addErrorMsgToResponse(String error) {
        ResponseError responseError = new ResponseError();
        responseError.setDetails(error);
        responseError.setDateTime(LocalDateTime.now());
        setErrors(responseError);
    }
}
