package com.diesgut.medical.apijwt.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.bcel.classfile.Constant;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.diesgut.medical.apijwt.constants.Constants;
import com.diesgut.medical.apijwt.model.JwtAuthenticationToken;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter{


	public JwtAuthenticationTokenFilter() {
		//indicamos como comienzan el endpoint de las urls que sera auditadas
		//super("/api/**");
		super("/api/**");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		//aqui validaremos el jwt es correcto
		String header=request.getHeader(Constants.AUTHORIZATION_HEADER);
		if(header==null || !header.startsWith(Constants.BEARER_TOKEN)) {
			throw new RuntimeException("jwt incorrecto");
		}
		String authorizationToken=header.substring(Constants.BEARER_TOKEN.length());
		JwtAuthenticationToken token=new JwtAuthenticationToken(authorizationToken); 
		return getAuthenticationManager().authenticate(token);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		// TODO Auto-generated method stub
		super.successfulAuthentication(request, response, chain, authResult);
		chain.doFilter(request, response);
	}
	
	

}
