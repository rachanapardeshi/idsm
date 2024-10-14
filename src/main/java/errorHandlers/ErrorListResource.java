package errorHandlers;

import java.util.Arrays;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema(name="ErrorListResource", description="Standard error response message")
public class ErrorListResource {
    private String requestId;
    private List<ErrorMessage> errors;

    public ErrorListResource(String requestId, ErrorMessage... errors){
        this(requestId, Arrays.asList(errors));
    }

    public ErrorListResource(String requestId, List<ErrorMessage> errors) {
        this.requestId = requestId;
        this.errors = errors;
    }

    public List<ErrorMessage> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorMessage> errors) {
        this.errors = errors;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public static ErrorListResource toResponse(String requestId, ErrorCode errorCode, String moreInfo) {
        return new ErrorListResource(requestId, new ErrorMessage(errorCode, moreInfo));
    }
}
