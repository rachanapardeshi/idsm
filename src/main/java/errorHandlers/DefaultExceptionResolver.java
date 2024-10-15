package errorHandlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.ModelAndView;

public class DefaultExceptionResolver extends GenericAbstractHandler {

    public DefaultExceptionResolver(Jackson2ObjectMapperBuilder jacksonBuilder) {
        super(jacksonBuilder);
    }

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {

        logger.error("Throwable error description: " + e.getMessage());
        logger.error("Throwable error. ", e);
      //  System.out.println("Getmessage::::::::::::"+e.getMessage());
        
        String requestId = "requestId";
        ErrorCode errorCode = ErrorCode.ERR1500;
        ErrorListResource resource = new ErrorListResource(requestId, new ErrorMessage(errorCode, null));
        return renderResponse(response, errorCode.getHttpStatus(), resource);
    }
}
