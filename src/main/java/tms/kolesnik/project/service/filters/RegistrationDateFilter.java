package tms.kolesnik.project.service.filters;

import jakarta.servlet.*;

import java.io.IOException;

public class RegistrationDateFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    public void doFilter(ServletRequest var1, ServletResponse var2, FilterChain var3) throws IOException, ServletException {
        //check enter date
    }

    public void destroy() {
        Filter.super.destroy();
    }
}
