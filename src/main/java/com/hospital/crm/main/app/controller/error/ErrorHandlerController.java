package com.hospital.crm.main.app.controller.error;

import com.hospital.crm.main.app.model.error.ErrorResponse;
import com.hospital.crm.main.app.model.error.exception.HospitalCrmException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Arrays;

import static com.hospital.crm.main.app.model.error.ErrorMessages.INTERNAL_SERVER_ERROR;
import static com.hospital.crm.main.app.model.error.ErrorMessages.VALIDATION_ERROR;

@ControllerAdvice
@Validated
public class ErrorHandlerController {

    @Value("${hospital-crm.debug.enabled}")
    private Boolean debug;

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @ExceptionHandler({RuntimeException.class, HospitalCrmException.class})
    public ErrorResponse handleRuntimeExceptionAndHospitalCrmException(RuntimeException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        if (Boolean.TRUE.equals(debug)) {
            errorResponse.setDebug(Arrays.toString(ex.getStackTrace()));
        }
        errorResponse.setMessage(INTERNAL_SERVER_ERROR);
        errorResponse.setDetailMessage(ex.getMessage());
        return errorResponse;
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ErrorResponse handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(VALIDATION_ERROR);
        errorResponse.setDetailMessage(ex.getMessage());
        if (Boolean.TRUE.equals(debug)) {
            errorResponse.setDebug(Arrays.toString(ex.getStackTrace()));
        }
        return errorResponse;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(VALIDATION_ERROR);

        errorResponse.setDetailMessage(ex.getMessage());
        if (Boolean.TRUE.equals(debug)) {
            errorResponse.setDebug(Arrays.toString(ex.getStackTrace()));
        }
        return errorResponse;
    }

}
