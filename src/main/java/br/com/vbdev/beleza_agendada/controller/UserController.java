package br.com.vbdev.beleza_agendada.controller;

import br.com.vbdev.beleza_agendada.model.BeautySalonModel;
import br.com.vbdev.beleza_agendada.model.UserModel;
import br.com.vbdev.beleza_agendada.model.form.UserForm;
import br.com.vbdev.beleza_agendada.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/create")
    @Transactional
    public UserForm create(@RequestBody @Valid UserForm user) {
            return service.createUser(user);
    }

    @GetMapping("/{id}")
    @Transactional
    public UserForm getUser(@PathVariable @Valid Long id) {
        return service.getUser(id);
    }

    @GetMapping
    @Transactional
    public List<UserForm> getAll(){
        return service.getAll();
    }
}
