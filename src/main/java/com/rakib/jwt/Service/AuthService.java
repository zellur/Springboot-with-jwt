package com.rakib.jwt.Service;

import com.rakib.jwt.Security.JwtTokenProvider;
import com.rakib.jwt.entity.Role;
import com.rakib.jwt.entity.User;
import com.rakib.jwt.enums.RoleName;
import com.rakib.jwt.model.UserModel;
import com.rakib.jwt.repository.RoleRepository;
import com.rakib.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collections;

@Service
public class AuthService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;


    public String getJwt(UserModel userModel) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userModel.getEmail(),
                        userModel.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return jwt;
    }

    public UserModel registerUser(UserModel signUpRequest) {

        if(userRepository.existsByUserName(signUpRequest.getUserName())) {
          return null;
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
           return null;
        }

        // Creating user's account
        User user = new User(signUpRequest);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByRoleName(RoleName.ROLE_USER.toString());
               if(userRole == null){
                   return null;
               }
        user.setRoles(Collections.singleton(userRole));

        User result = userRepository.save(user);

        return new UserModel(result);
    }

}
