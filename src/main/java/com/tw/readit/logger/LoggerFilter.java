package com.tw.readit.logger;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class LoggerFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        System.out.println(
                "request method : "
                        + httpServletRequest.getMethod()
                        + ", url : "
                        + httpServletRequest.getRequestURL());

        chain.doFilter(request, response);

        HttpServletResponse httpServletResponse =
                (HttpServletResponse) response;

        System.out.println(
                "response : "
                        + httpServletResponse.getStatus());
    }
}
