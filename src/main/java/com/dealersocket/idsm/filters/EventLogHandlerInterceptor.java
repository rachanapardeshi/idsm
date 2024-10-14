
package com.dealersocket.idsm.filters;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EventLogHandlerInterceptor implements HandlerInterceptor {
    private static final String OPERATION_NAME_HEADER = "X-OperationName";

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if (o instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) o;
            //Uppercase first char of the operationName to match the APIM format
            String operationName = handlerMethod.getMethod().getName();
            if (operationName != null && operationName.length() > 0)
                operationName = operationName.substring(0,1).toUpperCase() + operationName.substring(1);

            httpServletRequest.setAttribute("operationName", operationName);
            httpServletResponse.setHeader(OPERATION_NAME_HEADER, operationName);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}