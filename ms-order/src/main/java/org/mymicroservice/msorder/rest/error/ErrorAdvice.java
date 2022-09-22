package org.mymicroservice.msorder.rest.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(IllegalArgumentException exception) {
        return new ErrorObj().setMicroservice("ms-order")
                .setDesc(exception.getMessage())
                .setCode(1023);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(MethodArgumentNotValidException exception) {
        ErrorObj errorObj = new ErrorObj().setMicroservice("ms-order")
                .setDesc("validasyon problemi")
                .setCode(1023);
        exception.getAllErrors()
                .forEach(be -> errorObj.addError(new ErrorObj().setMicroservice("ms-order")
                        .setDesc(be.toString())
                        .setCode(1109)));
        return errorObj;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObj> handleException(Exception exception) {
        if (exception instanceof NullPointerException) {
            return ResponseEntity.status(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED)
                    .body(new ErrorObj().setMicroservice("ms-order")
                            .setDesc(exception.getMessage())
                            .setCode(1025));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorObj().setMicroservice("ms-order")
                        .setDesc(exception.getMessage())
                        .setCode(1023));
    }

}
