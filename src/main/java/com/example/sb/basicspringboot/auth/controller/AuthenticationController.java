package com.example.sb.basicspringboot.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.sb.basicspringboot.auth.payload.AuthToken;
import com.example.sb.basicspringboot.auth.payload.request.LoginUser;
import com.example.sb.basicspringboot.user.model.User;
import com.example.sb.basicspringboot.user.service.UserService;

@RestController
@RequestMapping("/api/v1/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final User user = userService.findOne(loginUser.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        return ResponseEntity.ok(new AuthToken(token));
    }

}
