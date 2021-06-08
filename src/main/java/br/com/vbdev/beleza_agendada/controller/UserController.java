package br.com.vbdev.beleza_agendada.controller;

import br.com.vbdev.beleza_agendada.config.security.AccountCredentialsVO;
import br.com.vbdev.beleza_agendada.config.security.jwt.JwtTokenProvider;
import br.com.vbdev.beleza_agendada.model.BeautySalonModel;
import br.com.vbdev.beleza_agendada.model.UserModel;
import br.com.vbdev.beleza_agendada.model.form.UserForm;
import br.com.vbdev.beleza_agendada.repository.UserRepository;
import br.com.vbdev.beleza_agendada.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    UserRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid UserForm user) {
            return ok(service.create(user));
    }

    private ResponseEntity<Map<Object, Object>> autenticar(AccountCredentialsVO account) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(account.getEmail(), account.getPassword()));

        var user = repository.findByUsername(account.getEmail());

        var token = "";

        if (user != null) {
            token = tokenProvider.createToken(account.getEmail(), user.getRoles());
        } else {
            throw new UsernameNotFoundException("Username " + user.getUsername() + " not found!");
        }

        Map<Object, Object> model = new HashMap<>();
        model.put("username", user.getUsername());
        model.put("token", token);
        return ok(model);
    }

    @GetMapping("/list")
    @ResponseBody
    @Transactional
    public ResponseEntity<List<UserForm>> getAll() {
        return ok(service.getAll());
    }
}
