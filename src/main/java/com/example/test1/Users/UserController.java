package com.example.test1.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    UserController() {}

    @PostMapping("/users/sign-up")
    public ResponseEntity signUp(@RequestBody Account user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        usersRepository.save(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/users/sign-in")
    public Object signIn(@RequestBody Account userCredencials) {
        Account user = usersRepository.findByUsername(userCredencials.getUsername());
        if (user.getPassword() == user.getPassword()) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }

}
