package com.example.vehiclemanager.config;

import com.example.vehiclemanager.dto.response.ErrorResponse;
import com.example.vehiclemanager.util.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handler for Entity Not Found exception
     *
     * @param e       EntityNotFoundException
     * @param request HttpServletRequest
     * @return ResponseEntity<ErrorResponse>
     */
    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(
            EntityNotFoundException e, HttpServletRequest request) {
        ErrorResponse response = buildErrorResponse(e, request);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    /**
     * Handler for any type of Exception
     *
     * @param e       Exception
     * @param request HttpServletRequest
     * @return ResponseEntity<ErrorResponse>
     */
    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponse> handleCommonException(
            Exception e, HttpServletRequest request) {
        ErrorResponse response = buildErrorResponse(e, request);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }

    /**
     * This function will create common error response
     *
     * @param ex      Exception
     * @param request HttpServletRequest
     * @return ErrorResponse
     */
    private ErrorResponse buildErrorResponse(Exception ex, HttpServletRequest request) {
        return ErrorResponse.builder()
                .href(Utils.getUrl(request))
                .method(request.getMethod())
                .error(ex.getMessage())
                .build();
    }
}
