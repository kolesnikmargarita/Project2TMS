package tms.kolesnik.project.servlets.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class UserAccountFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) req).getSession(false);

        boolean authorized;

        if (session == null) {
            authorized = false;
        } else {
            String authorizedAttribute = (String) session.getAttribute("authorized");
            authorized = authorizedAttribute != null && authorizedAttribute.equals("true");
        }

        if(!authorized) {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
