package com.nebula.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * URL logger for debugging purposes.
 */
@WebFilter(filterName = "UrlLogger", urlPatterns = { "/*" })
public class UrlLoggerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException
    {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        System.out.printf(
                "[INFO] Request starting HTTP %s %s\n",
                httpRequest.getMethod(),
                httpRequest.getRequestURI());

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}
