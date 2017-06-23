package com.koushik.movieflix;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns={"/api/**"})
public class JWTFilter implements Filter {

	@Override
	public void destroy() {
		

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		final HttpServletRequest request= (HttpServletRequest) req;
//		final HttpServletResponse response= (HttpServletResponse) res;
//		final String authHeader = request.getHeader("Authorization");
		
		if(allowedURL(request.getRequestURL().toString()))
		{
			chain.doFilter(req, res);
		}		
		else{
//			final String token = authHeader.substring(7);
			
//			if(authHeader == null || !authHeader.startsWith("Bearer ")){
//				throw new ServletException("Token Not Found");	
//		       }			
//			try {
//	            final Claims claims = Jwts.parser().setSigningKey("movieflix")
//	                .parseClaimsJws(token).getBody();
//	            request.setAttribute("claims", claims);
//	        }
//	        catch (final SignatureException e) {
//	            throw new ServletException("Invalid token.");
//	        }
	        chain.doFilter(req, res);
		}	
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}
	
	public boolean allowedURL(String url){
		boolean state = false;		
		List<String> urlList = new ArrayList<>();
		urlList.add("/signup");
		urlList.add("/login");
		urlList.add("/logout");
		for (String urls : urlList) {
			if(url.endsWith(urls))
			state =true;
			}
		return state;
	}
}
