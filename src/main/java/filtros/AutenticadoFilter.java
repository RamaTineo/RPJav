package filtros;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter({"/perfil.jsp", "/usuarios/*"})
public class AutenticadoFilter extends HttpFilter implements Filter {
       
  
	private static final long serialVersionUID = -2973598543570980135L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

	HttpServletRequest req = (HttpServletRequest)request;
	HttpServletResponse res = (HttpServletResponse)response;
	
	HttpSession session = req.getSession();
	String user = (String) session.getAttribute("user");
	
	
	if(user == null) {
		res.sendRedirect(req.getContextPath() + "/login");
		return;
	}
	
	
		chain.doFilter(request, response);
	}


}
