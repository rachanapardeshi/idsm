package errorHandlers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.ModelAndView;

public class ConstraintViolationExceptionResolver extends GenericAbstractHandler {
    private Pattern foreignKeyPattern = Pattern.compile("CONSTRAINT `(.*?)` FOREIGN KEY");

    public ConstraintViolationExceptionResolver(Jackson2ObjectMapperBuilder jacksonBuilder) {
        super(jacksonBuilder);
    }

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
        if (!(e instanceof ConstraintViolationException))
            return null;

        ConstraintViolationException typedException = (ConstraintViolationException) e;

        String constraintName = getConstraintName(typedException);
        ErrorCode errorCode = DatabaseConstraintConstants.findConstraintError(constraintName);
        String requestId ="requestId";
        if (errorCode != null) {
            return renderResponse(response, errorCode.getHttpStatus(),
                    new ErrorListResource(requestId, new ErrorMessage(errorCode, null)));
        }

        // We will have screwed up if this is in production:
        // we don't have a map entry for the problem.
        logger.error("We encountered a DB exception for which we have not created a specific error message. We should do that.", e);
        errorCode = ErrorCode.ERR1300;
        return renderResponse(response, errorCode.getHttpStatus(),
                new ErrorListResource(requestId, new ErrorMessage(errorCode, null)));
    }

    private String getConstraintName(ConstraintViolationException e) {
        // low-hanging fruit
        if (e.getConstraintName() != null)
            return e.getConstraintName();

        // foreign key violations don't get picked up in constraintName
        String message = e.getCause().getMessage();
        Matcher matcher = foreignKeyPattern.matcher(message);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
