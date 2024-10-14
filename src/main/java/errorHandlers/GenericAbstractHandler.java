package errorHandlers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Base class for exception handlers. Implements HandlerExceptionResolver,
 * does boilerplate for serialization of response object and setting status/content-type headers.
 *
 * NOTE: You want to set the order to something below 1, at least for
 * exception types that Spring poaches in its DefaultHandlerExceptionResolver,
 * such as MethodArgumentNotValidException and httpMediaTypeNotSupportedException.
 */
public abstract class GenericAbstractHandler extends AbstractHandlerExceptionResolver {
    //public Jackson2ObjectMapperBuilder jacksonBuilder;
    private ObjectMapper jacksonObjectMapper;

    public GenericAbstractHandler(Jackson2ObjectMapperBuilder jacksonBuilder) {
        setOrder(-10);
        this.jacksonObjectMapper = jacksonBuilder.build();
    }

    protected ModelAndView renderResponse(HttpServletResponse response, HttpStatus status, ErrorListResource responseObject) {
        try {
            response.setStatus(status.value());
            response.setContentType(MediaType.APPLICATION_JSON_UTF8.toString());

            //To comply with HTTP Protocol the header "Allow" must be returned for 405 responses
            if (status.compareTo(HttpStatus.METHOD_NOT_ALLOWED) == 0)
                response.setHeader("Allow", responseObject.getErrors().get(0).getMoreInfo()
                        .replace("[", "")
                        .replace("]",""));

            //ObjectMapper jacksonObjectMapper = jacksonBuilder.build();
            jacksonObjectMapper.writer().writeValue(response.getOutputStream(), responseObject);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ModelAndView();
    }
}
