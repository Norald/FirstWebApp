package filters;

import javax.jms.Session;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;
import java.io.IOException;

/**
 * Created by Prokop on 04.09.2016.
 */
@WebFilter(filterName = "IsSessionAvailableFilter", urlPatterns="/pages/*")
public class IsSessionAvailableFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;

        HttpSession session = request.getSession();
        if(session!=null||!session.isNew()){
            response.sendRedirect(request.getContextPath()+ "/index.jsp");
        }else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
