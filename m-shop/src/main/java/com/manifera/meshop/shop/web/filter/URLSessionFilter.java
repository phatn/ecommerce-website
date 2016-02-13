/**
 * 
 */
package com.manifera.meshop.shop.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * @author PhatNguyen
 *
 */

public class URLSessionFilter implements Filter {

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if(!(request instanceof HttpServletRequest)) {
			chain.doFilter(request, response);
			return;
		}
		
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpServletResponseWrapper wrappedResponse = new HttpServletResponseWrapper(httpResponse) {
			public String encodeRedirectUrl(String url) {
				return url;
			}
			public String encodeRedirectURL(String url) {
				return url;
			}
	
			public String encodeUrl(String url) {
				return url;
			}
	
			public String encodeURL(String url) {
				return url;
			}
		
		};
		chain.doFilter(request, wrappedResponse);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
