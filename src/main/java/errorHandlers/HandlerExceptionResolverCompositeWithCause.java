package errorHandlers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerExceptionResolverComposite;

/**
 * Based on Spring HandlerExceptionResolverComposite --
 * for each error, tests type of cause as well as exception itself.
 */
public class HandlerExceptionResolverCompositeWithCause extends HandlerExceptionResolverComposite implements HandlerExceptionResolver, Ordered {
    private DefaultExceptionResolver defaultExceptionResolver;

    public HandlerExceptionResolverCompositeWithCause(DefaultExceptionResolver defaultExceptionResolver) {
        this.defaultExceptionResolver = defaultExceptionResolver;
    }

    /**
     * Resolve the exception by iterating over the list of configured exception resolvers.
     * The first one to return a ModelAndView instance wins. Otherwise use DefaultExceptionResolver.
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler,
                                         Exception ex) {
        if (this.getExceptionResolvers() != null) {
            // first iterate over resolvers (except for DefaultExceptionResolver) and handle if match found
            for (HandlerExceptionResolver handlerExceptionResolver : this.getExceptionResolvers()) {
                ModelAndView mav = handlerExceptionResolver.resolveException(request, response, handler, ex);
                if (mav != null) {
                    return mav;
                }
            }

            // ... if no handler found, try matching on the exception cause
            Throwable cause = ex.getCause();
            if (cause instanceof Exception && cause != ex) {
                for (HandlerExceptionResolver handlerExceptionResolver : this.getExceptionResolvers()) {
                    ModelAndView mav = handlerExceptionResolver.resolveException(request, response, handler, (Exception) cause);
                    if (mav != null) {
                        return mav;
                    }
                }
            }
        }

        return defaultExceptionResolver.resolveException(request, response, handler, ex);
    }

}
