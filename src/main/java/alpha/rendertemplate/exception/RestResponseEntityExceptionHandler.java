package alpha.rendertemplate.exception;

import alpha.rendertemplate.exception.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleInternalServerErrors(Exception ex) {
        String errorMessage = "Internal server error";
        ApiError jsonError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, errorMessage, ex);
        return buildResponseEntity(jsonError);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.status);
    }

}
