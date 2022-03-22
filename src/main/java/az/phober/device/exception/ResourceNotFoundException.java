package az.phober.device.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException  extends RuntimeException {
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    @Override
    public String getMessage() {
        return "Resource not found";
    }
}
