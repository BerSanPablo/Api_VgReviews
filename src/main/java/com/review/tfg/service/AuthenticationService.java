package com.review.tfg.service;

import com.review.tfg.dto.auth.request.LoginRequest;
import com.review.tfg.dto.auth.request.SignUpRequest;
import com.review.tfg.dto.auth.response.TokenDTO;

public interface AuthenticationService {
	public TokenDTO signup(SignUpRequest request);
	public TokenDTO signin(LoginRequest request);
}
