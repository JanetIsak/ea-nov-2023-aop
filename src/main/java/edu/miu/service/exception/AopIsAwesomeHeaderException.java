package edu.miu.service.exception;

public class AopIsAwesomeHeaderException extends RuntimeException {
    public AopIsAwesomeHeaderException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
