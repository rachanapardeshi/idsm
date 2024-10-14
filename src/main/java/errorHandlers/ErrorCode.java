package errorHandlers;


import java.util.regex.Pattern;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

	
	   //Authentication and authorization error constants'
    ERR401("Request not authenticated", null, HttpStatus.UNAUTHORIZED),
	
	ERR1300("Data constraint/integrity violation", null, HttpStatus.CONFLICT),
	   
   
    ERR1111("Data constraint/integrity violation", "An Account with such ID already exists", HttpStatus.CONFLICT),
    ERR1500("Internal server error", null, HttpStatus.INTERNAL_SERVER_ERROR),
	;

	
    private String userMessage;
    private String errorDescription;
    private HttpStatus httpStatus;
    private Pattern pattern;
    private boolean nullable = true;
  

    private ErrorCode(String userMessage, String errorDescription) {
        this.userMessage = userMessage;
        this.errorDescription = errorDescription;
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }

    private ErrorCode(String userMessage, String errorDescription, HttpStatus httpStatus) {
        this.userMessage = userMessage;
        this.errorDescription = errorDescription;
        this.httpStatus = httpStatus;
    }

    private ErrorCode(String userMessage, String errorDescription,
                      boolean nullable, String pattern, HttpStatus httpStatus) {
        this.userMessage = userMessage;
        this.errorDescription = errorDescription;
        this.httpStatus = httpStatus;
        this.nullable = nullable;
        this.pattern = Pattern.compile(pattern);
    }

    public String getUserMessage() {
        return userMessage;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public boolean isNullable() {
        return nullable;
    }

}