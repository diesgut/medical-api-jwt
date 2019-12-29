package com.diesgut.medical.apijwt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diesgut.medical.apijwt.model.JwtUser;
import com.diesgut.medical.apijwt.model.Login;
import com.diesgut.medical.apijwt.security.JwtGenerator;

@RestController
@RequestMapping("/token")
public class TokenController {

	private JwtGenerator jwtGenerator;

	public TokenController(JwtGenerator jwtGenerator) {
		this.jwtGenerator = jwtGenerator;
	}

	@PostMapping
	public ResponseEntity<String> generate(@RequestBody final Login login) {
		JwtUser jwtUser = new JwtUser();
		jwtUser = exisUser(login);
		if(jwtUser!=null) {
			return new ResponseEntity<String>(jwtGenerator.generate(jwtUser),HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}

	private JwtUser exisUser(Login login) {
		//esta seria la llamada a base de datos
		if (login.getUser().equals("diesgut") && login.getPassword().equals("diesgut")) {
			JwtUser jwtUser = new JwtUser();
			jwtUser.setUserName("diesgut");
			jwtUser.setId(1L);
			jwtUser.setRole("ADMIN");
			return jwtUser;
		}
		return null;
	}

}
