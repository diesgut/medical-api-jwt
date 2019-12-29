package com.diesgut.medical.apijwt.security;

import org.springframework.stereotype.Component;

import com.diesgut.medical.apijwt.constants.Constants;
import com.diesgut.medical.apijwt.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {
	
	public JwtUser validate(String token) {
		JwtUser jwtUser=null;
		try {
			Claims body=Jwts.parser().setSigningKey(Constants.YOUR_SECRET )
					.parseClaimsJws(token)
					.getBody();
			
			jwtUser=new JwtUser();
			jwtUser.setUserName(body.getSubject());
			jwtUser.setId( Long.parseLong( (String) body.get( Constants.USER_ID ) ) );
			jwtUser.setRole( (String) body.get( Constants.ROLE ) );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jwtUser;
	}

}
